@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import externals.VAR_COLOR_PRIMARY
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun Card(
    vararg className: String,
    content: @Composable () -> Unit,
) {
    Style(CardStyle)

    Div({ classes(*className, CardStyle.content) }) {
        Div({ classes("mdc-card") }) { content() }
    }
}

private object CardStyle : StyleSheet() {
    val content by style {
        position(Position.Relative)
        maxWidth(800.px)
    }
}
