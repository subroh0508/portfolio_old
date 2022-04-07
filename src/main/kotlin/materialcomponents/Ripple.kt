@file:JsModule("@rmwc/ripple")

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface RippleProps : StyledProps {
    var accent: Boolean?
    var disabled: Boolean?
    var primary: Boolean?
    var surface: Boolean?
    var unbounded: Boolean?
}

external val Ripple: ElementType<RippleProps>
