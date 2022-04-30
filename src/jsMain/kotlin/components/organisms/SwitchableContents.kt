@file:Suppress("FunctionName")

package components.organisms

import androidx.compose.runtime.Composable
import components.molecules.*
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun SwitchableContents(
    titles: List<String>,
    vararg content: @Composable () -> Unit,
) {
    val index = 1
    val prev = "?p=${index - 1}"
    val next = "?p=${index + 1}"

    Style(SwitchableContentsStyle)

    Switcher(titles[index], prev, next)
    Div({
        classes(SwitchableContentsStyle.chevronRight)
    }) { content[index]() }
}

private object SwitchableContentsStyle : StyleSheet() {
    private val slideInRight by slide(true)
    private val slideInLeft by slide(false)

    val chevronRight by style {
        animation(slideInRight) {
            duration(0.5.s)
            fillMode(AnimationFillMode.Forwards)
        }
    }

    val chevronLeft by style {
        animation(slideInLeft) {
            duration(0.5.s)
            fillMode(AnimationFillMode.Forwards)
        }
    }


    @OptIn(ExperimentalComposeWebApi::class)
    private fun slide(right: Boolean) = keyframes {
        from {
            opacity(0.0)
            transform { translateX((if (right) 24 else -24).px) }
        }
        to {
            opacity(1.0)
            transform { translateX(0.px) }
        }
    }
}
