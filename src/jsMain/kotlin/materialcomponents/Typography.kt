@file:JsModule("@rmwc/typography")
@file:JsNonModule

package materialcomponents

import react.ElementType
import react.PropsWithClassName

external interface TypographyProps : PropsWithClassName {
    var use: String?
    var tag: String?
}

external val Typography: ElementType<TypographyProps>
