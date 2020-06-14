package components.biography.maps

import react.RProps

external interface MapProps : RProps

val MapProps.root: String
    get() = asDynamic()["classes"]["root"]
