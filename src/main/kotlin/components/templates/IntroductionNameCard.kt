package components.templates

import components.atoms.CardFrame
import components.atoms.LargeSubtitle
import components.atoms.LargeTitle
import react.child
import react.dom.WithClassName
import react.functionalComponent

external interface IntroductionNameCardProps : WithClassName {
    var name: String
    var subName: String
}

val IntroductionNameCard = functionalComponent<IntroductionNameCardProps> { props ->
    child(CardFrame) {
        child(LargeTitle) { attrs.title = props.name }
        child(LargeSubtitle) { attrs.subtitle = props.subName }
    }
}
