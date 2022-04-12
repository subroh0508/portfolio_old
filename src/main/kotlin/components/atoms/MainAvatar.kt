@file:Suppress("FunctionName")

package components.atoms

import csstype.px
import emotion.react.css
import emotion.styled.styled
import materialcomponents.Avatar
import materialcomponents.AvatarSize
import materialcomponents.size
import react.FC
import react.PropsWithClassName

external interface MainAvatarProps : PropsWithClassName {
    var src: String?
}

val MainAvatar = FC<MainAvatarProps> { props ->
    StyledAvatar {
        css(props.className) {}

        ripple = false
        src = props.src
        size(AvatarSize.xlarge)
    }
}

private val StyledAvatar = Avatar.styled { _, _ ->
    width = 100.px
    height = 100.px
}
