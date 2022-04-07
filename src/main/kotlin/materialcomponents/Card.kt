@file:JsModule("@rmwc/card")

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface CardProps : StyledProps {
    var outlined: Boolean?
}

external val Card : ElementType<CardProps>
