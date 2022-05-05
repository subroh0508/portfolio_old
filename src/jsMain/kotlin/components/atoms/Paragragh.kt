@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import utilities.getLetterSpacing

@Composable
fun ComposableParagraph(content: @Composable () -> Unit) {
    Style(ParagraphStyle)

    P({ classes(ParagraphStyle.font, ParagraphStyle.body1) }) {
        content()
    }
}

private object ParagraphStyle : StyleSheet() {
    val font by style {
        fontFamily("Roboto", "sans-serif")
        property("-webkit-font-smoothing", "antialiased")
    }

    val body1 by style {
        fontWeight("normal")
        fontSize(1.cssRem)
        lineHeight(1.5.cssRem)
        letterSpacing(getLetterSpacing(0.5, 1.0))
        color(org.jetbrains.compose.web.css.Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
    }
}
