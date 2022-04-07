@file:JsModule("@rmwc/icon")
@file:JsNonModule

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface IconProps : StyledProps {
    var icon: dynamic
}

external val Icon : ElementType<IconProps>
