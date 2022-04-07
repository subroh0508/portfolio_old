@file:JsModule("@rmwc/avatar")
@file:JsNonModule

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface AvatarProps : StyledProps {
    var src: String?
    var size: String?
    var name: String?
    var square: Boolean?
    var interactive: Boolean?
    var contain: Boolean?
    var ripple: Boolean?
}

external val Avatar: ElementType<AvatarProps>
