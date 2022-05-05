@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Tr

@Composable
fun TableRow(content: @Composable () -> Unit) {
    Style(TableRowStyle)

    Tr({ classes(TableRowStyle.row) }) {
        content()
    }
}

private object TableRowStyle : StyleSheet() {
    val row by style {
        type("td") style {
            position(Position.Relative)
        }

        type("td::after") style {
            property("content", "''")
            position(Position.Absolute)
            left(0.px)
            right(0.px)
            bottom(0.px)
            property("border-bottom", "1px solid var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
        }
    }
}
