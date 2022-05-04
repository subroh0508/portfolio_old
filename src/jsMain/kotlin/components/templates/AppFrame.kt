@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.*
import components.organisms.Navigation
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun AppFrame(
    menu: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Style(AppFrameStyle)

    Div({ classes(AppFrameStyle.container) }) {
        Navigation(
            title = { AppFrameTitle() },
            menu = { menu() },
        )

        AppFrameContent(content)
    }
}

@Composable
private fun AppFrameTitle() {
    Span { Text("Subroh Nishikori's") }
    Span { Text("Portfolio") }
}

@Composable
private fun AppFrameContent(content: @Composable () -> Unit) = Div({
    classes(AppFrameStyle.content)
}) {
    content()
    ComposableFooter()
}

private object AppFrameStyle : StyleSheet() {
    val container by style {
        display(DisplayStyle.Flex)
        height(100.percent)
    }

    val content by style {
        flexGrow(1.0)
        marginLeft(224.px)

        className("card-frame") style {
            marginTop(64.px)
        }
    }
}
