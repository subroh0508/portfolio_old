@file:Suppress("FunctionName")

package components.organisms.introduction

import androidx.compose.runtime.Composable
import components.atoms.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun NameCardHeader(
    name: String,
    subName: String,
    avatarSrc: String,
    posts: List<String>,
) {
    Style(NameCardHeaderStyle)

    Div({ classes(NameCardHeaderStyle.header) }) {
        Avatar(NameCardHeaderStyle.avatar, avatarSrc)

        Div {
            LargeTitle(NameCardHeaderStyle.name, text = name)
            Subtitle(NameCardHeaderStyle.subName, text = subName)

            posts.forEach { post ->
                LargeSubtitle(NameCardHeaderStyle.post, text = post)
            }
        }
    }
}

private object NameCardHeaderStyle : StyleSheet() {
    val header by style {
        display(DisplayStyle.Flex)
    }

    val avatar by style {
        property("margin", "auto 24px")
    }

    val name by style {
        marginBottom(0.px)
    }

    val subName by style {
        marginTop(0.px)
        marginBottom(16.px)
    }

    val post by style {
        marginTop(0.px)
        marginBottom(0.px)
    }
}
