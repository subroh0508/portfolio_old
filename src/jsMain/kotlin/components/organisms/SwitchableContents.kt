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
    index: Pair<Int, Int>,
    click: (Int) -> Unit,
    vararg content: @Composable () -> Unit,
) {
    val (last, current) = index
    if (current !in titles.indices) {
        return
    }

    val prev = if (current in 1 until titles.size) current - 1 else null
    val next = if (current in 0 until titles.size - 1) current + 1 else null

    Switcher(titles[current], prev, next, click)
    content.forEachIndexed { i, block ->
        SlideContent(last, current, current == i, block)
    }
}

@Composable
private fun SlideContent(
    last: Int,
    current: Int,
    isVisible: Boolean,
    content: @Composable () -> Unit,
) {
    Style(SwitchableContentsStyle)

    Div({
        style {
            display(if (isVisible) DisplayStyle.Block else DisplayStyle.None)

            when (last) {
                -1 -> property("animation", "none")
                current - 1 -> animation(SwitchableContentsStyle.slideInRight) {
                    duration(0.5.s)
                    fillMode(AnimationFillMode.Forwards)
                }
                current + 1 -> animation(SwitchableContentsStyle.slideInLeft) {
                    duration(0.5.s)
                    fillMode(AnimationFillMode.Forwards)
                }
                else -> property("animation", "none")
            }
        }
    }) { content() }
}

private object SwitchableContentsStyle : StyleSheet() {
    val slideInRight by slide(true)
    val slideInLeft by slide(false)

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
