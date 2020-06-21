@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.height
import kotlinx.css.px
import kotlinx.css.width
import materialcomponents.Avatar
import materialcomponents.AvatarProps
import materialcomponents.AvatarSize
import materialcomponents.size
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

external interface MainAvatarProps : WithClassName {
    var src: String?
}

val MainAvatar = functionalComponent<MainAvatarProps> { props ->
    StyledAvatar(props.className) {
        attrs.ripple = false
        attrs.src = props.src
        attrs.size(AvatarSize.xlarge)
    }
}

private fun RBuilder.StyledAvatar(className: String?, handler: StyledHandler<AvatarProps>) = (styled(Avatar)) {
    css {
        className?.let(classes::add)
        width = 100.px
        height = 100.px
    }

    handler()
}
