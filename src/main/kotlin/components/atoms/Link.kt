@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import kotlinx.html.A
import kotlinx.html.SPAN
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledA
import styled.styledSpan

external interface LinkProps : WithClassName {
    var href: String
    var target: String?
}

val Link = functionalComponent<LinkProps> { props ->
    StyledLink(props.className) {
        attrs.href = props.href
        attrs.target = props.target ?: "_blank"

        props.children()
    }
}

val LinkText = functionalComponent<WithClassName> { props ->
    StyledLinkText(props.className) { props.children() }
}

private fun RBuilder.StyledLink(className: String? = null, handler: StyledDOMBuilder<A>.() -> Unit) = styledA {
    css {
        className?.let(classes::add)
        textDecoration = TextDecoration.none
        cursor = Cursor.pointer
    }

    handler()
}

private fun RBuilder.StyledLinkText(className: String? = null, handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        className?.let(classes::add)

        hover {
            textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
        }
    }

    handler()
}
