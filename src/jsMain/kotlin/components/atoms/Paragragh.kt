@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import csstype.Color
import csstype.FontWeight
import emotion.styled.styled
import materialcomponents.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import react.FC
import react.PropsWithChildren
import react.PropsWithClassName
import utilities.getLetterSpacing

external interface ParagraphProps : PropsWithChildren, PropsWithClassName

@Composable
fun ComposableParagraph(content: @Composable () -> Unit) {
    Style(ParagraphStyle)

    P({ classes(ParagraphStyle.font, ParagraphStyle.body1) }) {
        content()
    }
}

val Paragraph = FC<ParagraphProps> { props ->
    StyledBody1 {
        use(TypographyUse.body1)
        tag = "p"

        +props.children
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

private val StyledBody1 = Typography.styled { _, _ ->
    fontWeight = FontWeight.normal
    color = Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)")
}
