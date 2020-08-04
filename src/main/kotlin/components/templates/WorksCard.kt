package components.templates

import components.atoms.LargeTitle
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import components.organisms.titles
import react.child
import react.dom.WithClassName
import react.dom.div
import react.functionalComponent

val WorksCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(LargeTitle) {
            attrs.title = "Works"
        }

        child(SwitchableContents) {
            attrs.titles("kotlin-material-ui", "otonashi")

            div {
                +"Kotlin Material UI"
            }

            div {
                +"Otonashi"
            }
        }
    }
}
