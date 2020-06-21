@file:Suppress("FunctionName")

package components.organisms

import kotlinx.css.*
import kotlinx.html.DIV
import kotlinx.html.IMG
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv
import styled.styledImg

external interface NameCardPhotoProps : WithClassName {
    var photoSrc: String
}

val NameCardPhoto = functionalComponent<NameCardPhotoProps> { props ->
    StyledPhotoRoot {
        StyledImg {
            attrs.src = props.photoSrc
        }
    }
}

private fun RBuilder.StyledPhotoRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        margin(LinearDimension.auto, 24.px, 24.px, LinearDimension.auto)
    }

    handler()
}

private fun RBuilder.StyledImg(handler: StyledDOMBuilder<IMG>.() -> Unit) = styledImg {
    css {
        borderRadius = 50.pct
        height = 240.px
        width = LinearDimension.auto
    }

    handler()
}


