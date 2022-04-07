@file:Suppress("FunctionName")

package components.organisms

import components.molecules.*
import history.Location
import kotlinx.css.*
import kotlinx.css.properties.*
import kotlinx.js.jso
import react.*
import react.router.useLocation
import react.router.useNavigate
import styled.*
import styled.styled
import utilities.*

external interface SwitchableContentsProps : StyledProps {
    var titles: Array<out String>
}

fun SwitchableContentsProps.titles(vararg title: String) { titles = title }

val SwitchableContents = fc<SwitchableContentsProps> { props ->
    val navigate = useNavigate()
    val location = useLocation()
    val (index, prevIndex) = location.let {

        it.getPageQuery() to (it.switcherState?.prev ?: -1)
    }

    useEffectOnce {
        // Redirect to first page when access out of range
        if (index !in 0..props.titles.size) {
            navigate(
                location.pathname + FIRST_PAGE_QUERY,
                jso { replace = true },
            )
        }
    }

    StyledSwitcher(index, props.titles, location)

    Children.toArray(props.children).forEachIndexed { i, child ->
        styledDiv {
            css {
                display = if (i == index) Display.block else Display.none

                when (prevIndex) {
                    -1 -> animation  = Animations.none
                    index - 1 -> slideInRight()
                    index + 1 -> slideInLeft()
                    else -> animation = Animations.none
                }
            }

            child(child)
        }
    }
}

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
private val Location.switcherState: SwitcherState? get() = state as? SwitcherState

private fun CssBuilder.slideInRight() = slideIn(true)
private fun CssBuilder.slideInLeft() = slideIn(false)

private fun CssBuilder.slideIn(right: Boolean) = animation(duration = 0.5.s, fillMode = FillMode.forwards) {
    from { opacity = 0; transform { translateX((if (right) 24 else -24).px) } }
    to { opacity = 1.0; transform { translateX(0.px) } }
}

private fun RBuilder.StyledSwitcher(
        index: Int,
        titles: Array<out String>,
        location: Location
) = (styled(Switcher)) {
    css {
        descendants(".$CHEVRON_LEFT_CLASS_NAME") {
            visibility = if (index == 0) Visibility.hidden else Visibility.visible
        }
        descendants(".$CHEVRON_RIGHT_CLASS_NAME") {
            visibility = if (index + 1 == titles.size) Visibility.hidden else Visibility.visible
        }
    }

    attrs.title = titles[index]
    attrs.prev = location.prevPageQuery()
    attrs.next = location.nextPageQuery(titles.size - 1)
    attrs.state = state(location.getPageQuery())
}

private fun state(prev: Int): SwitcherState = jso { this.prev = prev }


