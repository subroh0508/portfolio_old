package components.biography.maps

import kotlinx.html.id
import materialui.styles.childWithStyles
import react.RBuilder
import react.RComponent
import react.RHandler
import react.dom.div
import react.setState
import styles.googleMapStyle
import kotlin.browser.window

class MapComponent : RComponent<MapProps, MapState>() {
    override fun componentDidMount() {
        setState { map = window.initMap() }
    }

    override fun RBuilder.render() {
        div(props.root) {
            attrs.id = "googleMap"
        }
    }
}

fun RBuilder.googleMap(handler: RHandler<MapProps>)
        = childWithStyles(MapComponent::class, googleMapStyle, handler = handler)