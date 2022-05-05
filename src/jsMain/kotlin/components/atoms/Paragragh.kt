@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P

@Composable
fun Paragraph(content: @Composable () -> Unit) {
    Style(ParagraphStyle)

    P({ classes(ParagraphStyle.body1, "mdc-typography--body1") }) {
        content()
    }
}

private object ParagraphStyle : StyleSheet() {
    val body1 by style {
        fontWeight("normal")
        color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
    }
}
