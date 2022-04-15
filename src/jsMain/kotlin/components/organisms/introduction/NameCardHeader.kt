@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.LargeSubtitle
import components.atoms.LargeTitle
import components.atoms.MainAvatar
import components.atoms.Subtitle
import csstype.Auto
import csstype.Display
import csstype.Margin
import csstype.px
import emotion.styled.styled
import react.FC
import react.PropsWithClassName
import react.dom.html.ReactHTML.div

external interface NameCardHeaderProps : PropsWithClassName {
    var name: String
    var subName: String
    var avatarSrc: String
    var posts: Array<out String>
}

fun NameCardHeaderProps.posts(vararg post: String) { posts = post }

val NameCardHeader = FC<NameCardHeaderProps> { props ->
    HeaderRoot {
        StyledMainAvatar
    }

    HeaderRoot {
        StyledMainAvatar { src = props.avatarSrc }

        div {
            StyledName { title = props.name }
            StyledSubName { subtitle = props.subName }

            props.posts.forEach { post -> StyledPost { subtitle = post } }
        }
    }
}

private val HeaderRoot = div.styled { _, _ ->
    display = Display.flex
}

private val StyledMainAvatar = MainAvatar.styled { _, _ ->
    margin = Margin(Auto.auto, 24.px)
}

private val StyledName = LargeTitle.styled { _, _ ->
    marginBottom = 0.px
}

private val StyledSubName = Subtitle.styled { _, _ ->
    marginTop = 0.px
    marginBottom = 16.px
}

private val StyledPost = LargeSubtitle.styled { _, _ ->
    marginTop = 0.px
    marginBottom  = 0.px
}
