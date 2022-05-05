package components.atoms

import androidx.compose.runtime.Composable
import externals.attachRippleTo
import org.jetbrains.compose.web.attributes.AttrsScope
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Style
import org.jetbrains.compose.web.css.StyleSheet
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.dom.TagElement
import org.w3c.dom.HTMLElement
import utilities.TagElementBuilder

@Composable
fun Ripple(
    applyAttrs: (AttrsScope<HTMLElement>.() -> Unit)? = null,
    tag: String = "div",
    content: @Composable () -> Unit,
) {
    Style(RippleStyle)

    TagElement(
        TagElementBuilder(tag),
        {
            applyAttrs?.invoke(this)

            classes(RippleStyle.surface, "mdc-ripple-surface")
            ref {
                val ripple = attachRippleTo(it)
                onDispose {
                    ripple.deactivate()
                }
            }
        },
    ) { content() }
}

private object RippleStyle : StyleSheet() {
    val surface by style {
        type("::before") style  {
            backgroundColor(Color.white)
        }
        type("::after") style  {
            backgroundColor(Color.white)
        }
    }
}
