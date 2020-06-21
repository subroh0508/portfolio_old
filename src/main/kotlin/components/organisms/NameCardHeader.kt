@file:Suppress("FunctionName")

package components.organisms

import components.atoms.*
import kotlinx.css.marginBottom
import kotlinx.css.marginTop
import kotlinx.css.px
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import utilities.styled

external interface NameCardHeaderProps : WithClassName {
    var name: String
    var subName: String
    var avatarSrc: String
}

val NameCardHeader = functionalComponent<NameCardHeaderProps> { props ->
    child(MainAvatar) { attrs.src = props.avatarSrc }

    StyledName { attrs.title = props.name }
    StyledSubName { attrs.subtitle = props.subName }
}

private fun RBuilder.StyledName(handler: StyledHandler<LargeTitleProps>) = (styled(LargeTitle)) {
    css {
        marginBottom = 0.px
    }

    handler()
}

private fun RBuilder.StyledSubName(handler: StyledHandler<LargeSubtitleProps>) = (styled(LargeSubtitle)) {
    css {
        marginTop = 0.px
    }

    handler()
}
