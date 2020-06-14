package components.atoms

import react.RProps
import react.dom.div
import react.functionalComponent

@JsName("Card")
val Card = functionalComponent<CardProps> { props ->
    div { +props.title }
}

external interface CardProps : RProps {
    var title: String
}
