@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Footer() {
    Style(FooterStyle)

    Div({ classes(FooterStyle.container) }) {
        Span({ classes(FooterStyle.text) }) {
            Text("Last Modified: 2022-05-06T17:09:36+0900")
            Br {}
            Text("Copyright© 2022 subroh_0508 Official Website. All Rights Reserved.")
        }
    }
}

private object FooterStyle : StyleSheet() {
    val container by style {
        display(DisplayStyle.Flex)
        height(100.vh - (800 * 55.0 / 91.0).px - 64.px)
        minHeight(128.px)
        alignItems(AlignItems.FlexEnd)
        color(rgba(255, 255, 255, 0.38))
    }

    val text by style {
        width(100.percent)
        textAlign("center")
        padding(40.px, 0.px)
    }
}
