@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.html.DIV
import materialcomponents.Card
import materialcomponents.VAR_COLOR_PRIMARY
import materialcomponents.VAR_COLOR_SURFACE
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.*

val CardFrame = functionalComponent<WithClassName> { props ->
    NameCardWrapper {
        Card { props.children() }
    }
}

private fun RBuilder.NameCardWrapper(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        position = Position.relative
        maxWidth = 800.px

        before {
            content = "".quoted
            display = Display.block
            paddingTop = (55.0 / 91.0 * 100).pct
        }

        descendants(".mdc-card") {
            position = Position.absolute
            top = 0.px
            left = 0.px
            bottom = 0.px
            right = 0.px

            borderRadius = 0.px
            padding(16.px)
            backgroundColor = Color(VAR_COLOR_PRIMARY.toCustomProperty())
        }
    }

    handler()
}
