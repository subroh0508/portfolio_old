package components.biography.profiles

import react.RProps

external interface BirthdayProps : RProps

val BirthdayProps.root: String
    get() = asDynamic()["classes"]["root"] as String