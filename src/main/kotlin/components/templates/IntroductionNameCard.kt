package components.templates

import components.atoms.CardFrame
import components.organisms.NameCardHeader
import components.organisms.NameCardHeaderProps
import kotlinext.js.require
import react.child
import react.functionalComponent

external interface IntroductionNameCardProps : NameCardHeaderProps

// val avatar = require("./avatar.jpg")

val IntroductionNameCard = functionalComponent<IntroductionNameCardProps> { props ->
    child(CardFrame) {
        child(NameCardHeader) {
            attrs.name = props.name
            attrs.subName = props.subName
            attrs.avatarSrc = "avatar.jpg"
        }
    }
}
