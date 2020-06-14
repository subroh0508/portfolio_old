package components.biography.profiles

import components.biography.CardProps
import materialui.styles.StylesBuilder
import materialui.styles.childWithStyles
import react.RBuilder
import react.RProps
import react.ReactElement
import react.buildElement
import react.dom.div

external interface ProfileProps : CardProps {
    var classNamePrefix: String
    var title: ReactElement?
    var cardContent: ReactElement?
}

fun ProfileProps.title(block: RBuilder.() -> Unit) { title = buildElement(block) }
fun <P: RProps> ProfileProps.cardContent(
    displayName: String,
    paragraphStylesSet: StylesBuilder<P>.() -> Unit,
    render: RBuilder.(P) -> Unit
) {
    cardContent = buildElement {
        childWithStyles(displayName, paragraphStylesSet, render = { props: P ->
            div { render(props) }
        }).invoke {  }
    }
}

val ProfileProps.googleMapStyle: String
    get() = asDynamic()["classes"]["googleMap"] as String
