package components.works

import components.MainProps
import components.root
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.mainStyle

val RBuilder.work
    get() = childWithStyles<MainProps>("Work", mainStyle) { props ->
        div(props.root) {
            div("grid-root") {
                project { }
                speak { }
            }
        }
    }