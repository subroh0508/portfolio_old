package components.atoms

import androidx.compose.runtime.Composable
import externals.attachRippleTo
import org.jetbrains.compose.web.dom.TagElement
import utilities.TagElementBuilder

@Composable
fun Ripple(
    tag: String = "div",
    vararg className: String,
    content: @Composable () -> Unit,
) = TagElement(
    TagElementBuilder(tag),
    {
        classes(*className, "mdc-ripple-surface")
        ref {
            val ripple = attachRippleTo(it)
            onDispose {
                ripple.deactivate()
            }
        }
    },
) { content() }
