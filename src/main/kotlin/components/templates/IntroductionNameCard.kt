@file:Suppress("FunctionName")

package components.templates

import components.atoms.Card
import components.organisms.CardFrame
import components.organisms.introduction.NameCardHeader
import components.organisms.introduction.NameCardLinks
import components.organisms.introduction.NameCardPhoto
import components.organisms.introduction.posts
import kotlinx.css.*
import kotlinx.html.SPAN
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.StyledHandler
import styled.css
import styled.styledSpan
import utilities.styled

val IntroductionNameCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(NameCardHeader) {
            attrs.name = "にしこりさぶろ〜"
            attrs.subName = "Subroh Nishikori"
            attrs.avatarSrc = "avatar.jpg"
            attrs.posts(
                "担当: 速水奏・三峰結華・真壁瑞希・樋口円香",
                "副業: Android/Webエンジニア"
            )
        }

        StyledRowSpan {
            child(NameCardLinks) {
                attrs.homepage = "subroh0508.net"
                attrs.twitter = "subroh_0508"
                attrs.github = "subroh0508"
                attrs.email = "in-the-n@me-of.love"
            }

            child(NameCardPhoto) {
                attrs.photoSrc = "otonashi_kotlin.webp"
            }
        }
    }
}

private fun RBuilder.StyledRowSpan(handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        display = Display.flex
        height = 100.pct
    }

    handler()
}
