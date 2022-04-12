@file:Suppress("FunctionName")

package components.organisms.introduction

import csstype.*
import emotion.react.css
import emotion.styled.styled
import materialcomponents.VAR_COLOR_SURFACE
import react.FC
import react.PropsWithClassName
import react.dom.html.ReactHTML.div

external interface NameCardPhotoProps : PropsWithClassName {
    var photoSrc: String
}

val NameCardPhoto = FC<NameCardPhotoProps> { props ->
    StyledPhotoRoot {
        Photo {
            src = props.photoSrc
        }
    }
}

private val StyledPhotoRoot = div.styled { _, _ ->
    margin = Margin((-24).px, 24.px, 0.px, Auto.auto)
}

private external interface PhotoProps : PropsWithClassName {
    var src: String
}

private val Photo = FC<PhotoProps> { props ->
    div {
        css {
            height = 280.px
            width = 210.px
            backgroundImage = url(props.src)
            backgroundSize = BackgroundSize.cover
        }

        div {
            css {
                backgroundImage = "radial-gradient(ellipse, transparent 50%, var(--$VAR_COLOR_SURFACE) 72%)".unsafeCast<Gradient>()
                height = 280.px
                width = 210.px
            }
        }
    }
}
