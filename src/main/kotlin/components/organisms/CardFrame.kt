@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Card
import kotlinx.css.LinearDimension
import kotlinx.css.margin
import kotlinx.css.px
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import utilities.styled

val CardFrame = functionalComponent<WithClassName> { props ->
    StyledCardFrame { props.children() }
}

private fun RBuilder.StyledCardFrame(handler: StyledHandler<WithClassName>) = (styled(Card)) {
    css {
        margin(0.px, LinearDimension.auto)
    }

    handler()
}
