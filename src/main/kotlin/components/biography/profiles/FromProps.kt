package components.biography.profiles

import react.RProps

external interface FromProps : RProps

val FromProps.paragraphStyle: String
    get() = asDynamic()["classes"]["paragraph"] as String
val FromProps.googleMapStyle: String
    get() = asDynamic()["classes"]["googleMap"] as String
