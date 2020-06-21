@file:JsModule("@rmwc/avatar")

package materialcomponents

import react.RClass
import react.dom.WithClassName

external interface AvatarProps : WithClassName {
    var src: String?
    var size: String?
    var name: String?
    var square: Boolean?
    var interactive: Boolean?
    var contain: Boolean?
    var ripple: Boolean?
}

external val Avatar: RClass<AvatarProps>
