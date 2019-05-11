package components.header

import react.RProps

external interface HeaderProps : RProps

val HeaderProps.root: String
    get() = asDynamic()["classes"]["root"] as String
val HeaderProps.appBar: String
    get() = asDynamic()["classes"]["appBar"] as String
