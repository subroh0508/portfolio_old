@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import utilities.TagElementBuilder

@Composable
fun LargeTitle(
    className: String? = null,
    tag: String = "h2",
    text: String,
) {
    Style(TypographySheet)

    val styles = listOfNotNull(
        className,
        TypographySheet.h4,
        "mdc-typography--headline4",
    )

    TagElement(
        TagElementBuilder(tag),
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
        TypographySheet.h5,
        "mdc-typography--headline5",
    )

    TagElement(
        TagElementBuilder(tag),
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
        TypographySheet.h6,
        "mdc-typography--headline6",
    )

    TagElement(
        TagElementBuilder(tag),
        { classes(*styles.toTypedArray()) },
    ) { Text(text) }
}

private object TypographySheet : StyleSheet() {
    val h4 by style {
        fontWeight("bold")
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
    }

    val h5 by style {
        color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
    }

    val h6 by style {
        fontWeight("normal")
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
    }
}
