@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Text

@Composable
fun Links(vararg links: Pair<String, String>) = links.forEachIndexed { i, link ->
    Link(link)
    if (i != links.size - 1) {
        Text("/")
    }
}

@Composable
fun Link(
    content: Pair<String, String>,
    target: ATarget = ATarget.Blank,
) {
    Style(LinkTextStyle)

    val (href, label) = content
    A(href, {
        classes(LinkTextStyle.text)
        target(target)
    }) { Text(label) }
}

@Composable
fun Link(
    href: String,
    target: ATarget = ATarget.Blank,
    content: @Composable () -> Unit,
) {
    Style(LinkStyle)

    A(href, { target(target) }) { content() }
}

private object LinkStyle : StyleSheet() {
    init {
        type("a") style {
            textDecoration("none")
            cursor("pointer")
            color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
        }
    }
}

private object LinkTextStyle : StyleSheet() {
    val text by style {
        textDecoration("underline")
    }
}
