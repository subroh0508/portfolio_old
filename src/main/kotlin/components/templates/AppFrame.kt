@file:Suppress("FunctionName")

package components.templates

import components.organisms.Navigation
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

val AppFrame = functionalComponent<WithClassName> { props ->
    StyledRowDiv {
        child(Navigation) {
            attrs.title = "Subroh Nishikori's Portfolio"
            attrs.items = arrayOf()
            attrs.selectedIndex = 0
        }

        StyledContent { props.children() }
    }
}

private fun RBuilder.StyledRowDiv(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        display = Display.flex
        height = 100.pct
    }

    handler()
}

private fun RBuilder.StyledContent(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        flex(1.0)
    }

    handler()
}
