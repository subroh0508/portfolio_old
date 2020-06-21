@file:Suppress("FunctionName")

package components.templates

import components.atoms.CardFrame
import components.organisms.*
import kotlinx.css.Display
import kotlinx.css.display
import kotlinx.css.height
import kotlinx.css.pct
import kotlinx.html.SPAN
import react.RBuilder
import react.child
import react.dom.span
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledSpan

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
