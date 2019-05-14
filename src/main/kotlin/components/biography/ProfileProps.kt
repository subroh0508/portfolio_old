package components.biography

external interface ProfileProps : CardProps

val ProfileProps.googleMapStyle: String
    get() = asDynamic()["classes"]["googleMap"] as String
