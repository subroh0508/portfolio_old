package components.biography

import components.biography.profiles.birthday
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.biographyStyle

val RBuilder.biography
    get() = childWithStyles<BiographyProps>("Biography", biographyStyle) { props ->
        div(props.root) {
            div("grid-root") {
                about { }
                birthday {  }
                //profile { }
            }
        }
    }
