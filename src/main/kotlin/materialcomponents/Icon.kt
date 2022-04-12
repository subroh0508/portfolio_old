@file:JsModule("@rmwc/icon")
@file:JsNonModule

package materialcomponents

import react.ElementType
import react.PropsWithClassName

external interface IconProps : PropsWithClassName {
    var icon: dynamic
}

external val Icon : ElementType<IconProps>
