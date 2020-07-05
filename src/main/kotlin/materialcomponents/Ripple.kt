@file:JsModule("@rmwc/ripple")

package materialcomponents

import react.RClass
import react.dom.WithClassName

external interface RippleProps : WithClassName {
    var accent: Boolean?
    var disabled: Boolean?
    var primary: Boolean?
    var surface: Boolean?
    var unbounded: Boolean?
}

external val Ripple: RClass<RippleProps>
