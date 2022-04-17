@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.*
import csstype.Display
import emotion.styled.styled
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.w3c.dom.HTMLElement
import react.FC
import react.PropsWithClassName
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

external interface NameCardHeaderProps : PropsWithClassName {
    var name: String
    var subName: String
    var avatarSrc: String
    var posts: Array<out String>
}

fun NameCardHeaderProps.posts(vararg post: String) { posts = post }

val NameCardHeader = FC<NameCardHeaderProps> { props ->
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        Style(NameCardHeaderStyle)

        Avatar(NameCardHeaderStyle.avatar, props.avatarSrc)

        Div {
            LargeTitle(NameCardHeaderStyle.name, text = props.name)
            Subtitle(NameCardHeaderStyle.subName, text = props.subName)

            props.posts.forEach { post ->
                LargeSubtitle(NameCardHeaderStyle.post, text = post)
            }
        }
    }

    HeaderRoot {
        ref { containerRef.current = it }
    }
}

private object NameCardHeaderStyle : StyleSheet() {
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

private val HeaderRoot = div.styled { _, _ ->
    display = Display.flex
}
