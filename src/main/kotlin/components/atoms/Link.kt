@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import kotlinx.html.A
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledA

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

fun RBuilder.StyledLink(className: String? = null, handler: StyledDOMBuilder<A>.() -> Unit) = styledA {
    css {
        className?.let(classes::add)
        textDecoration = TextDecoration.none
        cursor = Cursor.pointer
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())

        hover {
            textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
        }
    }

    handler()
}
