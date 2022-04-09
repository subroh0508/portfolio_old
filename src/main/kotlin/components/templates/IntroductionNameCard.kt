@file:Suppress("FunctionName")

package components.templates

import components.organisms.CardFrame
import components.organisms.introduction.NameCardHeader
import components.organisms.introduction.NameCardLinks
import components.organisms.introduction.NameCardPhoto
import components.organisms.introduction.posts
import csstype.Display
import csstype.pct
import emotion.styled.styled
import react.VFC
import react.dom.html.ReactHTML.span

val IntroductionNameCard = VFC {
    CardFrame {
        NameCardHeader {
            name = "にしこりさぶろ〜"
            subName = "Subroh Nishikori"
            avatarSrc = "avatar.jpg"
            posts(
                "担当: 速水奏・三峰結華・真壁瑞希・樋口円香",
                "副業: Android/Webエンジニア",
            )
        }

        StyledRowSpan {
            NameCardLinks {
                homepage = "subroh0508.net"
                twitter = "subroh_0508"
                github = "subroh0508"
                email = "in-the-n@me-of.love"
            }

            NameCardPhoto {
                photoSrc = "otonashi_kotlin.webp"
            }
        }
    }
}

private val StyledRowSpan = span.styled { _, _ ->
    display = Display.flex
    height = 100.pct
}
