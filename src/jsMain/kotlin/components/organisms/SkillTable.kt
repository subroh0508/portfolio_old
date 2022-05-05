@file:Suppress("FunctionName")

package components.organisms

import androidx.compose.runtime.Composable
import components.atoms.ComposableParagraph
import components.atoms.TableRow
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.attributes.colspan
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun SkillTable(content: @Composable () -> Unit) {
    Style(SkillTableStyle)

    Table({
        classes(SkillTableStyle.table)
    }) {
        Tbody {
            content()
        }
    }
}

@Composable
fun SkillRow(
    name: String,
    starCount: Int,
    since: String,
    content: @Composable () -> Unit,
) {
    val stars = ((0..4).joinToString("") { i -> if (i < starCount) "★" else "☆" })

    HeaderTableRow(name, stars, since)
    ParagraphTableRow(content)
}

@Composable
private fun HeaderTableRow(name: String, stars: String, since: String) {
    Style(HeaderTableRowStyle)

    TableRow {
        Td({ classes(HeaderTableRowStyle.data) }) { Text(name) }
        Td({ classes(HeaderTableRowStyle.data) }) { Text(stars) }
        Td({ classes(HeaderTableRowStyle.data) }) { Text("$since-") }
    }
}

@Composable
private fun ParagraphTableRow(content: @Composable () -> Unit) {
    Style(ParagraphTableRowStyle)

    TableRow {
        Td({
            classes(ParagraphTableRowStyle.data)
            colspan(3)
        }) {
            ComposableParagraph(content)
        }
    }
}

private object SkillTableStyle : StyleSheet() {
    val table by style {
        property("border-spacing", "0")
    }
}

private object HeaderTableRowStyle : StyleSheet() {
    val data by style {
        color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
        paddingTop(8.px)
    }
}

private object ParagraphTableRowStyle : StyleSheet() {
    val data by style {
        type("p") style {
            margin(8.px, 0.px)
        }
    }
}
