@file:Suppress("FunctionName")

package components.molecules

import components.atoms.ChevronLeft
import components.atoms.ChevronRight
import components.atoms.Subtitle
import components.atoms.SubtitleProps
import csstype.*
import emotion.react.css
import emotion.styled.styled
import materialcomponents.Ripple
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.FC
import react.PropsWithChildren
import react.dom.html.ReactHTML.span
import react.PropsWithClassName
import react.create
import react.dom.html.ReactHTML.a
import react.router.dom.Link as RouterLink

val CHEVRON_LEFT_CLASS_NAME = ClassName("chevron-left")
val CHEVRON_RIGHT_CLASS_NAME = ClassName("chevron-right")

external interface SwitcherProps : PropsWithClassName {
    var title: String
    var prev: String
    var next: String
    var state: SwitcherState
}

val Switcher = FC<SwitcherProps> { props ->
    StyledSpan {
        css(props.className) {}

        Rippled {
            className = CHEVRON_LEFT_CLASS_NAME
            to = props.prev
            state = props.state

            +ChevronLeft.create()
        }

        StyledSubtitle { subtitle = props.title }

        Rippled {
            className = CHEVRON_RIGHT_CLASS_NAME
            to = props.next
            state = props.state

            +ChevronRight.create()
        }
    }
}

private val StyledSpan = span.styled { _, _ ->
    display = Display.flex
    alignItems = AlignItems.center
    color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")

    ".mdc-ripple-surface" {
        before {
            backgroundColor = NamedColor.white
        }

        after {
            backgroundColor = NamedColor.white
        }
    }

    a {
        display = Display.flex
        width = 24.px
        height = 24.px
        justifyContent = JustifyContent.center
        cursor = Cursor.pointer
        color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
        textDecoration = None.none
    }
}

external interface SwitcherState {
    var prev: Int
}

private external interface RippledProps : PropsWithChildren, PropsWithClassName {
    var to: String
    var state: SwitcherState
}

private val Rippled = FC<RippledProps> { props ->
    Ripple {
        unbounded = true

        RouterLink {
            css(props.className) {}
            to = props.to
            state = props.state

            +props.children
        }
    }
}

private val StyledSubtitle = FC<SubtitleProps> { props ->
    Subtitle {
        css {
            width = 200.px
            margin = Margin(8.px, 0.px)
            textAlign = TextAlign.center
        }

        subtitle = props.subtitle
    }
}
