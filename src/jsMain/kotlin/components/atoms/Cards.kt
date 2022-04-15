@file:Suppress("FunctionName")

package components.atoms

import csstype.*
import emotion.css.keyframes
import emotion.react.css
import emotion.styled.styled
import materialcomponents.CardProps
import materialcomponents.Card as CardComponent
import materialcomponents.VAR_COLOR_PRIMARY
import react.*
import react.dom.html.ReactHTML.div

val Card = FC<CardProps> { props ->
    NameCardWrapper {
        css(props.className) {}

        CardComponent { +props.children }
    }
}

private val NameCardWrapper = div.styled { _, _ ->
    position = Position.relative
    maxWidth = 800.px

    before {
        asDynamic()["content"] = "''"
        display = Display.block
        paddingTop = (55.0 / 91.0 * 100).pct
    }

    ".mdc-card" {
        position = Position.absolute
        top = 0.px
        left = 0.px
        bottom = 0.px
        right = 0.px

        borderRadius = 0.px
        padding = Padding(16.px, 16.px)
        backgroundColor = Color("var(--$VAR_COLOR_PRIMARY)")

        animationName = keyframes {
            from { opacity = number(0.0); transform = translatex(100.px) }
            to { opacity = number(1.0); transform = translatex(0.px) }
        }
        animationDuration = 0.75.s
        animationFillMode = AnimationFillMode.forwards
    }
}
