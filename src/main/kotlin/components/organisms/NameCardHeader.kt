@file:Suppress("FunctionName")

package components.organisms

import components.atoms.LargeSubtitle
import components.atoms.LargeTitle
import kotlinx.css.marginBottom
import kotlinx.css.marginTop
import kotlinx.css.px
import kotlinx.html.DIV
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

external interface NameCardHeaderProps : WithClassName {
    var name: String
    var subName: String
}

val NameCardHeader = functionalComponent<NameCardHeaderProps> { props ->
    NameCardHeaderWrapper {
        child(LargeTitle) { attrs.title = props.name }
        child(LargeSubtitle) { attrs.subtitle = props.subName }
    }
}

private fun RBuilder.NameCardHeaderWrapper(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        children("h1") {
            marginBottom = 0.px
        }

        children("h3") {
            marginTop = 0.px
        }
    }

    handler()
}

