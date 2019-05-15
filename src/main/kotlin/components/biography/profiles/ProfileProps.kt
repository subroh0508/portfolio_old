package components.biography.profiles

import components.biography.CardProps
import materialui.styles.StylesSet
import materialui.styles.childWithStyles
import react.RBuilder
import react.RProps
import react.ReactElement
import react.buildElement

external interface ProfileProps : CardProps {
    var classNamePrefix: String
    var title: ReactElement?
    var cardContent: ReactElement?
}

fun ProfileProps.title(block: RBuilder.() -> Unit) { title = buildElement(block) }
fun <P: RProps> ProfileProps.cardContent(
    displayName: String,
    paragraphStylesSet: StylesSet.() -> Unit,
    render: RBuilder.(P) -> Unit
) {
    cardContent = buildElement {
        childWithStyles(displayName, paragraphStylesSet, render = render).invoke {  }
    }
}

val ProfileProps.googleMapStyle: String
    get() = asDynamic()["classes"]["googleMap"] as String
