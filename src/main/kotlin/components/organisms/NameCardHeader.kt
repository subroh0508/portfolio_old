@file:Suppress("FunctionName")

package components.organisms

import components.atoms.*
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.dom.WithClassName
import react.dom.div
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.StyledHandler
import styled.css
import styled.styledDiv
import utilities.styled

external interface NameCardHeaderProps : WithClassName {
    var name: String
    var subName: String
    var avatarSrc: String
}

val NameCardHeader = functionalComponent<NameCardHeaderProps> { props ->
    HeaderRoot {
        StyledMainAvatar { attrs.src = props.avatarSrc }

        div {
            StyledName { attrs.title = props.name }
            StyledSubName { attrs.subtitle = props.subName }
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
        margin(16.px, 16.px, 16.px)
    }

    handler()
}

private fun RBuilder.StyledName(handler: StyledHandler<TitleProps>) = (styled(LargeTitle)) {
    css {
        marginBottom = 0.px
    }

    handler()
}

private fun RBuilder.StyledSubName(handler: StyledHandler<SubtitleProps>) = (styled(LargeSubtitle)) {
    css {
        marginTop = 0.px
    }

    handler()
}
