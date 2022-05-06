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
    current: Int,
    click: (Int) -> Unit,
    vararg content: @Composable () -> Unit,
) {
    if (current !in titles.indices) {
        return
    }

    val prev = if (current in 1 until titles.size) current - 1 else null
    val next = if (current in 0 until titles.size - 1) current + 1 else null

    Style(SwitchableContentsStyle)

    Switcher(titles[current], prev, next, click)
    Div({
        classes(SwitchableContentsStyle.chevronRight)
    }) { content[current]() }
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
