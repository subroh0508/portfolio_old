@file:Suppress("FunctionName")

package components.molecules

import components.atoms.ChevronLeft
import components.atoms.ChevronRight
import components.atoms.Subtitle
import kotlinext.js.jsObject
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.SPAN
import materialcomponents.Ripple
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.*
import react.dom.WithClassName
import react.router.dom.RouteResultLocation
import styled.StyledDOMBuilder
import styled.css
import styled.styledSpan
import utilities.*

const val CHEVRON_LEFT_CLASS_NAME = "chevron-left"
const val CHEVRON_RIGHT_CLASS_NAME = "chevron-right"

external interface SwitcherProps : WithClassName {
    var title: String
    var location: RouteResultLocation
}

val Switcher = functionalComponent<SwitcherProps> { props ->
    val prevLinkTo = linkTo<SwitcherState>(props.location.pathname, search = props.location.prevPageQuery()).apply {
        state(props.location.getPageQuery())
    }
    val nextLinkTo = linkTo<SwitcherState>(props.location.pathname, search = props.location.nextPageQuery()).apply {
        state(props.location.getPageQuery())
    }

    StyledSpan {
        props.className?.let(css.classes::add)

        Rippled(CHEVRON_LEFT_CLASS_NAME, prevLinkTo, ChevronLeft)
        StyledSubtitle(props.title)
        Rippled(CHEVRON_RIGHT_CLASS_NAME, nextLinkTo, ChevronRight)
    }
}

private fun RBuilder.StyledSpan(handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        display = Display.flex
        alignItems = Align.center
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())

        descendants(".mdc-ripple-surface") {
            before {
                backgroundColor = Color.white
            }

            after {
                backgroundColor = Color.white
            }
        }

        a {
            display = Display.flex
            width = 24.px
            height = 24.px
            justifyContent = JustifyContent.center
            cursor = Cursor.pointer
            color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
            textDecoration = TextDecoration.none
        }
    }

    handler()
}

external interface SwitcherState {
    var prev: Int
}

private fun LinkTo<SwitcherState>.state(prev: Int) { state = jsObject { this.prev = prev } }

private fun RBuilder.Rippled(
        className: String,
        linkTo: LinkTo<SwitcherState>,
        functionalComponent: FunctionalComponent<WithClassName>
): ReactElement = Ripple {
    attrs.unbounded = true

    routeLink(to = linkTo, className = className) {
        child(functionalComponent)
    }
}

private fun RBuilder.StyledSubtitle(title: String) = (styled(Subtitle)) {
    attrs.subtitle = title

    css {
        width = 200.px
        margin(vertical = 8.px)
        textAlign = TextAlign.center
    }
}
