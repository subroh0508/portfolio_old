@file:Suppress("FunctionName")

package components.molecules

import androidx.compose.runtime.Composable
import components.atoms.Link
import components.atoms.Subtitle
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span

@Composable
fun LinkWithIcon(
    href: String,
    label: String,
    content: @Composable (String) -> Unit,
) {
    Style(LinkWithIconSheet)

    Link(href) {
        Span({ classes(LinkWithIconSheet.span) }) {
            content(LinkWithIconSheet.icon)

            Subtitle(LinkWithIconSheet.caption, "span", label)
        }
    }
}

private object LinkWithIconSheet : StyleSheet() {
    val span by style {
        display(DisplayStyle.Flex)
        alignItems("center")
    }

    val icon by style {
        marginRight(CSSUnitValueTyped(8.toFloat(), CSSUnit.px))
        hover {
            textDecoration("none")
        }
    }

    val caption by style {
        marginTop(CSSUnitValueTyped(0.toFloat(), CSSUnit.px))
        marginBottom(CSSUnitValueTyped(0.toFloat(), CSSUnit.px))

        hover {
            textDecoration("underline")
        }
    }
}
