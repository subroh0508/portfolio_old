@file:Suppress("FunctionName")

package components.organisms

import components.molecules.CHEVRON_LEFT_CLASS_NAME
import components.molecules.CHEVRON_RIGHT_CLASS_NAME
import components.molecules.Switcher
import components.molecules.SwitcherState
import kotlinx.css.*
import kotlinx.css.properties.*
import react.*
import react.dom.WithClassName
import react.router.dom.RouteResultLocation
import react.router.dom.useHistory
import react.router.dom.useRouteMatch
import styled.animation
import styled.css
import styled.styledDiv
import utilities.getPageQuery
import utilities.state
import utilities.styled

external interface SwitchableContentsProps : WithClassName {
    var titles: Array<out String>
}

fun SwitchableContentsProps.titles(vararg title: String) { titles = title }

val SwitchableContents = functionalComponent<SwitchableContentsProps> { props ->
    console.log("aaa")
    val match = useRouteMatch<RProps>("/works")
    console.log(match)
    val location = useHistory().location
    val (index, prevIndex) = location.let {
        it.getPageQuery() to (it.switcherState?.prev ?: -1)
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
private val RouteResultLocation.switcherState: SwitcherState? get() = state as? SwitcherState

private fun CSSBuilder.slideInRight() = slideIn(true)
private fun CSSBuilder.slideInLeft() = slideIn(false)

private fun CSSBuilder.slideIn(right: Boolean) = animation(duration = 0.5.s, fillMode = FillMode.forwards) {
    from { opacity = 0; transform { translateX((if (right) 48 else -48).px) } }
    to { opacity = 1.0; transform { translateX(0.px) } }
}

private fun RBuilder.StyledSwitcher(
        index: Int,
        titles: Array<out String>,
        location: RouteResultLocation
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
    attrs.location = location
}


