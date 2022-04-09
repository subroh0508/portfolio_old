@file:JsModule("@rmwc/card")
@file:JsNonModule

package materialcomponents

import react.ElementType
import react.PropsWithClassName

external interface CardProps : PropsWithClassName {
    var outlined: Boolean?
}

external val Card : ElementType<CardProps>
