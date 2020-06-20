@file:JsModule("@rmwc/typography")

package materialcomponents

import react.RClass
import react.dom.WithClassName

external interface TypographyProps : WithClassName {
    var use: String?
    var tag: String?
}

external val Typography: RClass<TypographyProps>
