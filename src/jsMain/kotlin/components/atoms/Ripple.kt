package components.atoms

import androidx.compose.runtime.*
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
    unbounded: Boolean = false,
    content: @Composable () -> Unit,
) {
    var element by remember { mutableStateOf<HTMLElement?>(null) }

    SideEffect {
        element?.let { attachRippleTo(it) { isUnbounded = unbounded } }
    }

    Style(RippleStyle)

    TagElement(
        TagElementBuilder(tag),
        {
            applyAttrs?.invoke(this)

            classes(RippleStyle.surface, "mdc-ripple-surface")
            ref {
                element = it
                onDispose { element = null }
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
