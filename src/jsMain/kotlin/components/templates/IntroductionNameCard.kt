@file:Suppress("FunctionName")

package components.templates

import components.organisms.CardFrame
import components.organisms.introduction.NameCardHeader
import components.organisms.introduction.NameCardLinks
import components.organisms.introduction.NameCardPhoto
import csstype.pct
import emotion.react.css
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLElement
import react.VFC
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

val IntroductionNameCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        NameCardHeader(
            name = "にしこりさぶろ〜",
            subName = "Subroh Nishikori",
            avatarSrc = "avatar.jpg",
            posts = listOf(
                "担当: 速水奏・三峰結華・真壁瑞希・樋口円香",
                "副業: Android/Webエンジニア",
            ),
        )

        Span({
            style {
                display(DisplayStyle.Flex)
                // height(100.percent)
            }
        }) {
            NameCardLinks(
                homepage = "subroh0508.net",
                twitter = "subroh_0508",
                github = "subroh0508",
                email = "in-the-n@me-of.love",
            )

            NameCardPhoto("otonashi_kotlin.webp")
        }
    }

    CardFrame {
        div {
            css { height = 100.pct }
            ref { containerRef.current = it }
        }
    }
}
