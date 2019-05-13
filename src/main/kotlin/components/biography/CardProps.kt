package components.biography

import react.RProps

external interface CardProps : RProps

val CardProps.root: String
    get() = asDynamic()["root"] as String
val CardProps.cardContentStyle: String
    get() = asDynamic()["classes"]["cardContent"] as String
val CardProps.paragraphStyle: String
    get() = asDynamic()["classes"]["paragraph"] as String