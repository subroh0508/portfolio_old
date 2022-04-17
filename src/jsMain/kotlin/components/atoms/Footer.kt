@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import react.VFC
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

val Footer = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        ComposableFooter()
    }

    div {
        ref { containerRef.current = it }
    }
}

@Composable
fun ComposableFooter() {
    Div({
        style {
            display(DisplayStyle.Flex)
            height(100.vh - (800 * 55.0 / 91.0).px - 64.px)
            minHeight(128.px)
            alignItems(AlignItems.FlexEnd)
            color(rgba(255, 255, 255, 0.38))
        }
    }) {
        Span({
            style {
                width(100.percent)
                textAlign("center")
                padding(40.px, 0.px)
            }
        }) {
            Text("Last Modified: 2022-04-13T01:34:09+0900")
            Br {}
            Text("Copyright© 2022 subroh_0508 Official Website. All Rights Reserved.")
        }
    }
}
