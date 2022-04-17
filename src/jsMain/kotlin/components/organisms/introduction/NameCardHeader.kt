@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.*
import csstype.Display
import emotion.styled.styled
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
        Avatar(props.avatarSrc)

        Div {
            LargeTitle(props.name)
            Subtitle(props.subName)

            props.posts.forEach { post ->
                LargeSubtitle(post)
            }
        }
    }

    HeaderRoot {
        ref { containerRef.current = it }
    }
}

private val HeaderRoot = div.styled { _, _ ->
    display = Display.flex
}
