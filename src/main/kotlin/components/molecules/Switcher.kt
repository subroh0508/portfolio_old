@file:Suppress("FunctionName")

package components.molecules

import components.atoms.ChevronLeft
import components.atoms.ChevronRight
import components.atoms.Subtitle
import kotlinx.css.*
import kotlinx.html.SPAN
import materialcomponents.Ripple
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.FunctionalComponent
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledA
import styled.styledSpan
import utilities.styled

const val CHEVRON_LEFT_CLASS_NAME = "chevron-left"
const val CHEVRON_RIGHT_CLASS_NAME = "chevron-right"

external interface SwitcherProps : WithClassName {
    var title: String
}

val Switcher = functionalComponent<SwitcherProps> { props ->
    StyledSpan {
        props.className?.let(css.classes::add)

        Rippled(CHEVRON_LEFT_CLASS_NAME, ChevronLeft)
        StyledSubtitle(props.title)
        Rippled(CHEVRON_RIGHT_CLASS_NAME, ChevronRight)
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
    }

    handler()
}

private fun RBuilder.Rippled(className: String, functionalComponent: FunctionalComponent<WithClassName>) = Ripple {
    attrs.unbounded = true

    styledA {
        css {
            classes.add(className)
            display = Display.flex
            width = 24.px
            height = 24.px
            justifyContent = JustifyContent.center
            cursor = Cursor.pointer
        }

        child(functionalComponent) {}
    }
}

private fun RBuilder.StyledSubtitle(title: String) = (styled(Subtitle)) {
    attrs.subtitle = title

    css {
        width = 200.px
        textAlign = TextAlign.center
    }
}
