@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.organisms.CardFrame
import components.organisms.introduction.NameCardHeader
import components.organisms.introduction.NameCardLinks
import components.organisms.introduction.NameCardPhoto
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span

@Composable
fun IntroductionNameCard() = CardFrame {
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
            height(100.percent)
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
