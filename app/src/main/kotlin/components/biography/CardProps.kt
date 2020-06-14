package components.biography

import react.RProps

external interface CardProps : RProps

val CardProps.root: String
    get() = asDynamic()["classes"]["root"] as String
val CardProps.cardRootStyle: String
    get() = asDynamic()["classes"]["cardRoot"] as String
val CardProps.cardContentStyle: String
    get() = asDynamic()["classes"]["cardContent"] as String
val CardProps.paragraphStyle: String
    get() = asDynamic()["classes"]["paragraph"] as String