@file:JsModule("@rmwc/typography")

package materialcomponents

import react.ElementType
import styled.StyledProps

external interface TypographyProps : StyledProps {
    var use: String?
    var tag: String?
}

external val Typography: ElementType<TypographyProps>
