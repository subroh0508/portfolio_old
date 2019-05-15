package components.biography.profiles

import components.biography.maps.googleMap
import react.RBuilder
import react.dom.div

fun RBuilder.from(handler: ProfileProps.() -> Unit) = profile {
    attrs.classNamePrefix = "birthday"
    attrs.title { +"From: 伊豆大島" }

    div {

    }

    div(attrs.googleMapStyle) {
        googleMap {  }
    }
}