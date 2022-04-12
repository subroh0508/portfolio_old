@file:JsModule("@rmwc/card")
@file:JsNonModule

package materialcomponents

import react.ElementType
import react.PropsWithChildren
import react.PropsWithClassName

external interface CardProps : PropsWithChildren, PropsWithClassName {
    var outlined: Boolean?
}

external val Card : ElementType<CardProps>
