package components.templates

import components.atoms.CardFrame
import components.organisms.NameCardHeader
import components.organisms.NameCardHeaderProps
import components.organisms.posts
import react.child
import react.functionalComponent

external interface IntroductionNameCardProps : NameCardHeaderProps

val IntroductionNameCard = functionalComponent<IntroductionNameCardProps> { props ->
    child(CardFrame) {
        child(NameCardHeader) {
            attrs.name = props.name
            attrs.subName = props.subName
            attrs.avatarSrc = "avatar.jpg"
            attrs.posts(
                "担当: 速水奏・三峰結華・真壁瑞希",
                "副業: Android/Webエンジニア"
            )
        }
    }
}
