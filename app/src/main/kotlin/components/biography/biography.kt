package components.biography

import components.MainProps
import components.biography.profiles.birthday
import components.biography.profiles.from
import components.root
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.mainStyle

val RBuilder.biography
    get() = childWithStyles<MainProps>("Biography", mainStyle) { props ->
        div(props.root) {
            div("grid-root") {
                about { }
                birthday {  }
                from { }
                //profile { }
            }
        }
    }
