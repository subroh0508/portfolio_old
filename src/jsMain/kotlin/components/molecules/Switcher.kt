@file:Suppress("FunctionName")

package components.molecules

import androidx.compose.runtime.Composable
import components.atoms.*
import csstype.ClassName
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span

val CHEVRON_LEFT_CLASS_NAME = ClassName("chevron-left")
val CHEVRON_RIGHT_CLASS_NAME = ClassName("chevron-right")

@Composable
fun Switcher(
    label: String,
    prev: String? = null,
    next: String? = null,
) {
    Style(SwitcherStyle)

    val chevronLeftClassName = if (prev != null) SwitcherStyle.visible else SwitcherStyle.hidden
    val chevronRightClassName = if (next != null) SwitcherStyle.visible else SwitcherStyle.hidden

    Span({
        classes(SwitcherStyle.span)
    }) {
        Ripple { ComposableChevronLeft(chevronLeftClassName) }
        Subtitle(SwitcherStyle.subtitle, text = label)
        Ripple { ComposableChevronRight(chevronRightClassName) }
    }
}

@Composable
private fun Ripple(content: @Composable () -> Unit) { content() }

private object SwitcherStyle : StyleSheet() {
    val span by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))

        ".mdc-ripple-surface" {
            before {
                backgroundColor(Color.white)
            }

            after {
                backgroundColor(Color.white)
            }
        }

        type("a") style {
            display(DisplayStyle.Flex)
            width(24.px)
            height(24.px)
            justifyContent(JustifyContent.Center)
            cursor("pointer")
            color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
            textDecoration("none")
        }
    }

    val subtitle by style {
        width(200.px)
        margin(8.px, 0.px)
        textAlign("center")
    }

    val visible by style {
        property("visibility", "visible")
    }

    val hidden by style {
        property("visibility", "hidden")
    }
}
