@file:Suppress("FunctionName")

package components.organisms.introduction

import kotlinx.css.*
import kotlinx.html.DIV
import materialcomponents.VAR_COLOR_SURFACE
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

external interface NameCardPhotoProps : WithClassName {
    var photoSrc: String
}

val NameCardPhoto = functionalComponent<NameCardPhotoProps> { props ->
    StyledPhotoRoot { StyledImg(props.photoSrc) }
}

private fun RBuilder.StyledPhotoRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        margin((-24).px, 24.px, 0.px, LinearDimension.auto)
    }

    handler()
}

private fun RBuilder.StyledImg(src: String) = styledDiv {
    css {
        height = 280.px
        width = 210.px
        backgroundImage = Image("url('$src')")
        backgroundSize = "cover"
    }

    styledDiv {
        css {
            backgroundImage = Image("radial-gradient(ellipse, transparent 50%, ${VAR_COLOR_SURFACE.toCustomProperty()} 72%)")
            height = 280.px
            width = 210.px
        }
    }
}


