@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.*
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.dom.div
import react.fc
import styled.*

external interface NameCardHeaderProps : StyledProps {
    var name: String
    var subName: String
    var avatarSrc: String
    var posts: Array<out String>
}

fun NameCardHeaderProps.posts(vararg post: String) { posts = post }

val NameCardHeader = fc<NameCardHeaderProps> { props ->
    HeaderRoot {
        StyledMainAvatar { attrs.src = props.avatarSrc }

        div {
            StyledName { attrs.title = props.name }
            StyledSubName { attrs.subtitle = props.subName }

            props.posts.forEach { post -> StyledPost { attrs.subtitle = post } }
        }
    }
}

private fun RBuilder.HeaderRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
         display = Display.flex
    }

    handler()
}

private fun RBuilder.StyledMainAvatar(handler: StyledHandler<MainAvatarProps>) = (styled(MainAvatar)) {
    css {
        margin(LinearDimension.auto, 24.px)
    }

    handler()
}

private fun RBuilder.StyledName(handler: StyledHandler<TitleProps>) = (styled(LargeTitle)) {
    css {
        marginBottom = 0.px
    }

    handler()
}

private fun RBuilder.StyledSubName(handler: StyledHandler<SubtitleProps>) = (styled(Subtitle)) {
    css {
        marginTop = 0.px
        marginBottom = 16.px
    }

    handler()
}

private fun RBuilder.StyledPost(handler:  StyledHandler<SubtitleProps>) = (styled(LargeSubtitle)) {
    css {
        marginTop = 0.px
        marginBottom  = 0.px
    }

    handler()
}
