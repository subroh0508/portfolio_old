@file:Suppress("FunctionName")

package components.organisms

import androidx.compose.runtime.Composable
import components.atoms.Card
import csstype.ClassName
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet

val CARD_FRAME_CLASS = ClassName("card-frame")

@Composable
fun CardFrame(content: @Composable () -> Unit) {
    Style(CardFrameStyle)

    Card("card-frame", CardFrameStyle.card) {
        content()
    }
}

private object CardFrameStyle : StyleSheet() {
    val card by style {
        property("margin", "0 auto")
    }
}
