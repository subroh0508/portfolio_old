@file:JsModule("@rmwc/icon")

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface IconProps : StyledProps {
    var icon: dynamic
}

external val Icon : ElementType<IconProps>
