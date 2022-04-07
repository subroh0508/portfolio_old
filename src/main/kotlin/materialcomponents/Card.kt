@file:JsModule("@rmwc/card")
@file:JsNonModule

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface CardProps : StyledProps {
    var outlined: Boolean?
}

external val Card : ElementType<CardProps>
