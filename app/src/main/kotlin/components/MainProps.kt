package components

import react.RProps

external interface MainProps : RProps

val MainProps.root: String
    get() = asDynamic()["classes"]["root"] as String

