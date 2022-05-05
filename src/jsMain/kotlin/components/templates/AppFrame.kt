@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.*
import components.organisms.CARD_FRAME_CLASS
import components.organisms.Navigation
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun AppFrame(
    menu: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    Style(AppFrameStyle)

    Div({ classes(AppFrameStyle.container) }) {
        Navigation(
            "Subroh Nishikori's",
            "Portfolio",
        ) { menu() }

        AppFrameContent(content)
    }
}

@Composable
private fun AppFrameContent(content: @Composable () -> Unit) = Div({
    classes(AppFrameStyle.content)
}) {
    content()
    Footer()
}

private object AppFrameStyle : StyleSheet() {
    val container by style {
        display(DisplayStyle.Flex)
        height(100.percent)
    }

    val content by style {
        flexGrow(1.0)
        marginLeft(224.px)

        className(CARD_FRAME_CLASS) style {
            marginTop(64.px)
        }
    }
}
