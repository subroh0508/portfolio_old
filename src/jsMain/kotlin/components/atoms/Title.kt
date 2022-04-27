@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import kotlinx.browser.document
import materialcomponents.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.Element
import org.w3c.dom.HTMLElement
import utilities.getLetterSpacing

@Composable
fun LargeTitle(
    className: String? = null,
    tag: String = "h2",
    text: String,
) {
    Style(TypographySheet)

    val styles = listOfNotNull(
        className,
        TypographySheet.font,
        TypographySheet.largeTitle,
    )

    TagElement(
        TypographyElementBuilder(tag),
        { classes(*styles.toTypedArray()) },
    ) { Text(text) }
}

@Composable
fun LargeSubtitle(
    className: String? = null,
    tag: String = "h3",
    text: String,
) {
    Style(TypographySheet)

    val styles = listOfNotNull(
        className,
        TypographySheet.font,
        TypographySheet.largeSubtitle,
    )

    TagElement(
        TypographyElementBuilder(tag),
        { classes(*styles.toTypedArray()) },
    ) { Text(text) }
}

@Composable
fun Subtitle(
    className: String? = null,
    tag: String = "h4",
    text: String,
) {
    Style(TypographySheet)

    val styles = listOfNotNull(
        className,
        TypographySheet.font,
        TypographySheet.subtitle,
    )

    TagElement(
        TypographyElementBuilder(tag),
        { classes(*styles.toTypedArray()) },
    ) { Text(text) }
}

private object TypographySheet : StyleSheet() {
    val font by style {
        fontFamily("Roboto", "sans-serif")
        property("-webkit-font-smoothing", "antialiased")
    }

    val largeTitle by style {
        fontWeight("bold")
        fontSize(2.125.cssRem)
        lineHeight(2.5.cssRem)
        letterSpacing(getLetterSpacing(0.25, 2.125))
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
    }

    val largeSubtitle by style {
        fontWeight("normal")
        fontSize(1.5.cssRem)
        lineHeight(2.cssRem)
        letterSpacing("normal")
        color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
    }

    val subtitle by style {
        fontWeight("normal")
        fontSize(1.25.cssRem)
        lineHeight(2.cssRem)
        letterSpacing(getLetterSpacing(0.25, 1.25))
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
    }
}

private class TypographyElementBuilder(private val tagName: String) : ElementBuilder<HTMLElement> {
    private val el: Element by lazy { document.createElement(tagName) }
    @Suppress("UNCHECKED_CAST")
    override fun create(): HTMLElement = el.cloneNode() as HTMLElement
}
