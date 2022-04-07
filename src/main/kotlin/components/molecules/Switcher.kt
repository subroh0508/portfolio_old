@file:Suppress("FunctionName")

package components.molecules

import components.atoms.ChevronLeft
import components.atoms.ChevronRight
import components.atoms.Subtitle
import csstype.ClassName
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.SPAN
import materialcomponents.Ripple
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.*
import styled.*
import react.router.dom.Link as RouterLink

const val CHEVRON_LEFT_CLASS_NAME = "chevron-left"
const val CHEVRON_RIGHT_CLASS_NAME = "chevron-right"

external interface SwitcherProps : StyledProps {
    var title: String
    var prev: String
    var next: String
    var state: SwitcherState
}

val Switcher = fc<SwitcherProps> { props ->
    StyledSpan {
        props.className.unsafeCast<String>().let(css.classes::add)

        Rippled(CHEVRON_LEFT_CLASS_NAME, props.prev, props.state, ChevronLeft)
        StyledSubtitle(props.title)
        Rippled(CHEVRON_RIGHT_CLASS_NAME, props.next, props.state, ChevronRight)
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

private fun RBuilder.Rippled(
        className: String,
        to: String,
        state: SwitcherState,
        fc: FC<StyledProps>
) = Ripple {
    attrs.unbounded = true

    RouterLink {
        attrs.className = ClassName(className)
        attrs.to = to
        attrs.state = state
        child(fc)
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
