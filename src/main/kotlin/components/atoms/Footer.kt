@file:Suppress("FunctionName")

package components.atoms

import csstype.*
import emotion.react.css
import react.VFC
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span

val Footer = VFC {
    div {
        css {
            display = Display.flex
            height = 100.vh - (800 * 55.0 / 91.0).px - 64.px
            minHeight = 128.px
            alignItems = AlignItems.flexEnd
            color = rgba(255, 255, 255, 0.38)
        }

        span {
            css {
                width = 100.pct
                textAlign = TextAlign.center
                padding = Padding(40.px, 0.px)
            }

            +"Last Modified: 2022-04-13T01:34:09+0900"
            br {}
            +"Copyright© 2022 subroh_0508 Official Website. All Rights Reserved."
        }
    }
}
