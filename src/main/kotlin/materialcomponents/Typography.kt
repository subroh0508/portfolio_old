@file:JsModule("@rmwc/typography")

package materialcomponents

import react.RClass
import react.RProps

external interface TypographyProps : RProps {
    var use: String?
    var tag: String?
}

external val Typography: RClass<TypographyProps>
