@file:Suppress("FunctionName")

package components.organisms

import androidx.compose.runtime.Composable
import components.atoms.Card
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*

const val CARD_FRAME_CLASS = "card-frame"

@Composable
fun CardFrame(content: @Composable () -> Unit) {
    Style(CardFrameStyle)

    Card(CARD_FRAME_CLASS, CardFrameStyle.card) {
        content()
    }
}

private object CardFrameStyle : StyleSheet() {
    init {
        type(".$CARD_FRAME_CLASS::before") style {
            property("content", "''")
            display(DisplayStyle.Block)
            paddingTop((55.0 / 91.0 * 100).percent)
        }
    }

    @OptIn(ExperimentalComposeWebApi::class)
    private val slideIn by keyframes {
        from {
            opacity(0.0)
            transform { translateX(100.px) }
        }
        to {
            opacity(1.0)
            transform { translateX(0.px) }
        }
    }

    val card by style {
        property("margin", "0 auto")

        type(".mdc-card") style {
            position(Position.Absolute)
            top(0.px)
            left(0.px)
            bottom(0.px)
            right(0.px)

            borderRadius(0.px)
            padding(16.px, 16.px)

            animation(slideIn) {
                duration(0.75.s)
                fillMode(AnimationFillMode.Forwards)
            }
        }
    }
}
