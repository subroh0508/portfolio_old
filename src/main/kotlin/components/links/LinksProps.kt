package components.links

import react.RProps

external interface LinksProps : RProps

val LinksProps.root: String
    get() = asDynamic()["classes"]["root"] as String
