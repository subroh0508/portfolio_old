package components.biography

import react.RProps

external interface BiographyProps : RProps

val BiographyProps.root: String
    get() = asDynamic()["classes"]["root"] as String