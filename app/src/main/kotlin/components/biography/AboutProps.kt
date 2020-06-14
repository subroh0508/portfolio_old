package components.biography

external interface AboutProps : CardProps

val AboutProps.avatarStyle: String
    get() = asDynamic()["classes"]["avatar"] as String