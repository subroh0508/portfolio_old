@file:JsModule("@rmwc/card")

package materialcomponents

import react.RClass
import react.dom.WithClassName

external interface CardProps : WithClassName {
    var outlined: Boolean?
}

external val Card : RClass<CardProps>
