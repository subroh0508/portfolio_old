@file:JsModule("@rmwc/card")
@file:JsNonModule

package materialcomponents

import org.w3c.dom.HTMLElement
import react.ElementType
import react.PropsWithChildren
import react.PropsWithClassName
import react.PropsWithRef

external interface CardProps : PropsWithChildren, PropsWithRef<HTMLElement>, PropsWithClassName {
    var outlined: Boolean?
}

external val Card : ElementType<CardProps>
