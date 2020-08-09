@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.css.properties.FillMode
import kotlinx.css.properties.s
import kotlinx.css.properties.transform
import kotlinx.css.properties.translateX
import kotlinx.html.DIV
import materialcomponents.Card as CardComponent
import materialcomponents.VAR_COLOR_PRIMARY
import react.Children
import react.RBuilder
import react.children
import react.dom.WithClassName
import react.functionalComponent
import styled.*

val Card = functionalComponent<WithClassName> { props ->
    NameCardWrapper(props.className) {
        CardComponent { props.children() }
    }
}

private fun RBuilder.NameCardWrapper(className: String?, handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        className?.let(classes::add)
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

            animation(duration = 0.75.s, fillMode = FillMode.forwards) {
                from { opacity = 0; transform { translateX(100.px) } }
                to { opacity = 1.0; transform { translateX(0.px) } }
            }
        }
    }

    handler()
}
