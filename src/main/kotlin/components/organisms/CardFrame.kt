@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Card
import csstype.ClassName
import kotlinx.css.LinearDimension
import kotlinx.css.margin
import kotlinx.css.px
import react.RBuilder
import react.fc
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styled

val CARD_FRAME_CLASS = ClassName("card-frame")

val CardFrame = fc<StyledProps> { props ->
    StyledCardFrame { props.children() }
}

private fun RBuilder.StyledCardFrame(handler: StyledHandler<StyledProps>) = (styled(Card)) {
    css {
        margin(0.px, LinearDimension.auto)
    }

    attrs.className = CARD_FRAME_CLASS

    handler()
}
