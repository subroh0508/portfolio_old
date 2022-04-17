@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import materialcomponents.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.H4
import org.jetbrains.compose.web.dom.Text

@Composable
fun LargeTitle(text: String) {
    Style(LargeTitleSheet)

    H2 { Text(text) }
}

private object LargeTitleSheet : TypographySheet() {
    init {
        "h2" style {
            fontWeight("bold")
            fontSize(2.125.cssRem)
            lineHeight(2.5.cssRem)
            letterSpacing(getLetterSpacing(0.25, 2.125))
            color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
            marginBottom(0.px)
        }
    }
}

@Composable
fun LargeSubtitle(text: String) {
    Style(LargeSubtitleSheet)

    H3 { Text(text) }
}

private object LargeSubtitleSheet : TypographySheet() {
    init {
        "h3" style {
            fontWeight("normal")
            fontSize(1.5.cssRem)
            lineHeight(2.cssRem)
            letterSpacing("normal")
            color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
            marginTop(0.px)
            marginBottom(0.px)
        }
    }
}

@Composable
fun Subtitle(text: String) {
    Style(SubtitleSheet)

    H4 { Text(text) }
}

private object SubtitleSheet : TypographySheet() {
    init {
        "h4" style {
            fontWeight("normal")
            fontSize(1.25.cssRem)
            lineHeight(2.cssRem)
            letterSpacing(getLetterSpacing(0.25, 1.25))
            color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
            marginTop(0.px)
            marginBottom(16.px)
        }
    }
}

open class TypographySheet : StyleSheet() {
    init {
        "h2, h3, h4" style {
            fontFamily("Roboto", "sans-serif")
            property("-webkit-font-smoothing", "antialiased")
        }
    }
}

private fun getLetterSpacing(
    tracking: Double,
    fontSize: Double,
) = (tracking / (fontSize * 16.0)) * 1.em
