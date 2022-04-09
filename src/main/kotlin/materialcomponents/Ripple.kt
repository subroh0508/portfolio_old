@file:JsModule("@rmwc/ripple")
@file:JsNonModule

package materialcomponents

import react.ElementType
import react.PropsWithChildren
import react.PropsWithClassName
import styled.StyledProps

external interface RippleProps : PropsWithChildren, PropsWithClassName {
    var accent: Boolean?
    var disabled: Boolean?
    var primary: Boolean?
    var surface: Boolean?
    var unbounded: Boolean?
}

external val Ripple: ElementType<RippleProps>
