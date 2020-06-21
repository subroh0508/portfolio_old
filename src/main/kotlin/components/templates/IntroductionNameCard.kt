package components.templates

import components.atoms.CardFrame
import components.organisms.NameCardHeader
import components.organisms.NameCardHeaderProps
import components.organisms.NameCardLinks
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

        child(NameCardLinks) {
            attrs.homepage = "subroh0508.net"
            attrs.twitter = "subroh_0508"
            attrs.github = "subroh0508"
            attrs.email = "in-the-n@me-of.love"
        }
    }
}
