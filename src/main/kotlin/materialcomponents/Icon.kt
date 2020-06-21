@file:JsModule("@rmwc/icon")

package materialcomponents

import react.RClass
import react.dom.WithClassName

external interface IconProps : WithClassName {
    var icon: dynamic
}

external val Icon : RClass<IconProps>
