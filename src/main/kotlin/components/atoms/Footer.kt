@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import react.dom.WithClassName
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledSpan

val Footer = functionalComponent<WithClassName> {
    styledDiv {
        css {
            display = Display.flex
            height = 100.vh - (800 * 55.0 / 91.0).px - 64.px
            minHeight = 104.px
            alignItems = Align.flexEnd
            color = Color.white.withAlpha(0.38)
        }

        styledSpan {
            css {
                width = 100.pct
                textAlign = TextAlign.center
                padding(vertical = 40.px)
            }

            +"Copyright© 2020 subroh_0508 Official Website. All Rights Reserved."
        }
    }
}
