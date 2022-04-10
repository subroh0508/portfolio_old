@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Card
import csstype.Auto
import csstype.ClassName
import csstype.Margin
import csstype.px
import emotion.react.css
import emotion.styled.styled
import react.FC
import react.PropsWithChildren

val CARD_FRAME_CLASS = ClassName("card-frame")

val CardFrame = FC<PropsWithChildren> { props ->
    StyledCard {
        css(CARD_FRAME_CLASS) {}

        +props.children
    }
}

private val StyledCard = Card.styled { _, _ ->
    margin = Margin(0.px, Auto.auto)
}
