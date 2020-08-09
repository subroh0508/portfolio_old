@file:Suppress("FunctionName")

package components.organisms

import components.molecules.*
import kotlinext.js.jsObject
import kotlinx.css.*
import kotlinx.css.properties.*
import react.*
import react.dom.WithClassName
import react.router.dom.RouteResultLocation
import react.router.dom.useHistory
import styled.animation
import styled.css
import styled.styledDiv
import utilities.*

external interface SwitchableContentsProps : WithClassName {
    var titles: Array<out String>
}

fun SwitchableContentsProps.titles(vararg title: String) { titles = title }

val SwitchableContents = functionalComponent<SwitchableContentsProps> { props ->
    val history = useHistory()
    val location = history.location
    val (index, prevIndex) = location.let {
        it.getPageQuery() to (it.switcherState?.prev ?: -1)
    }

    // Redirect to first page when access out of range
    if (index !in 0..props.titles.size) {
        history.replace(firstLinkTo(location))
        return@functionalComponent
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
    from { opacity = 0; transform { translateX((if (right) 24 else -24).px) } }
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
    attrs.prevLinkTo = prevLinkTo(location)
    attrs.nextLinkTo = nextLinkTo(location, titles.size - 1)
}

private fun firstLinkTo(location: RouteResultLocation) = linkTo<SwitcherState>(
        location.pathname, search = FIRST_PAGE_QUERY
)

private fun prevLinkTo(location: RouteResultLocation) = linkTo<SwitcherState>(
        location.pathname,
        search = location.prevPageQuery()
).apply { state(location.getPageQuery()) }

private fun nextLinkTo(location: RouteResultLocation, max: Int) = linkTo<SwitcherState>(
        location.pathname,
        search = location.nextPageQuery(max)
).apply { state(location.getPageQuery()) }

private fun LinkTo<SwitcherState>.state(prev: Int) { state = jsObject { this.prev = prev } }


