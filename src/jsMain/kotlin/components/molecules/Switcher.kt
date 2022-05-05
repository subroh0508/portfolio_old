@file:Suppress("FunctionName")

package components.molecules

import androidx.compose.runtime.Composable
import components.atoms.*
import externals.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span

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
        Ripple(tag = "a", unbounded = true) { ChevronLeft(chevronLeftClassName) }
        Subtitle(SwitcherStyle.subtitle, text = label)
        Ripple(tag = "a", unbounded = true) { ChevronRight(chevronRightClassName) }
    }
}

private object SwitcherStyle : StyleSheet() {
    val span by style {
        display(DisplayStyle.Flex)
        alignItems(AlignItems.Center)
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))

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
