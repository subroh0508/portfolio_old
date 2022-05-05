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

    val content by style {
        position(Position.Relative)
        maxWidth(800.px)

        type("::before") style  {
            property("content", "''")
            display(DisplayStyle.Block)
            paddingTop((55.0 / 91.0 * 100).percent)
        }

        type(".mdc-card") style {
            display(DisplayStyle.Flex)
            flexDirection(FlexDirection.Column)
            boxSizing("border-box")
            property("box-shadow", "0px 2px 1px -1px rgb(0, 0, 0, 0.2), 0px 1px 1px 0px rgb(0, 0, 0, 0.14), 0px 1px 3px 0px rgb(0, 0, 0, 0.12)")

            position(Position.Absolute)
            top(0.px)
            left(0.px)
            bottom(0.px)
            right(0.px)

            borderRadius(0.px)
            padding(16.px, 16.px)
            backgroundColor(Color("var(--$VAR_COLOR_PRIMARY)"))

            animation(slideIn) {
                duration(0.75.s)
                fillMode(AnimationFillMode.Forwards)
            }
        }
    }
}
