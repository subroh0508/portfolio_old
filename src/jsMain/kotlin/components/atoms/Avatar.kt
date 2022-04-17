@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span

@Composable
fun Avatar(src: String) {
    Style(AvatarStyle)

    Span({ classes(AvatarStyle.container) }) {
        Div({
            classes(AvatarStyle.icon)
            style {
                backgroundImage("url($src)")
                backgroundSize("cover")
            }
        }) {}
    }
}

private object AvatarStyle : StyleSheet() {
    val container by style {
        width(100.px)
        height(100.px)
        property("margin", "auto 24px")
    }

    val icon by style {
        width(100.px)
        height(100.px)
        borderRadius(50.percent)
    }
}
