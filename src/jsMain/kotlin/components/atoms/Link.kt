@file:Suppress("FunctionName")

package components.atoms

import csstype.Cursor
import csstype.None
import csstype.TextDecoration
import emotion.react.css
import emotion.styled.styled
import react.FC
import react.PropsWithChildren
import react.PropsWithClassName
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.span

external interface LinkProps : PropsWithChildren, PropsWithClassName {
    var href: String
    var target: AnchorTarget?
}

external interface LinkTextProps : PropsWithChildren, PropsWithClassName

val Link = FC<LinkProps> { props ->
    StyledLink {
        css(props.className) {}
        href = props.href
        target = props.target ?: AnchorTarget._blank

        +props.children
    }
}

val LinkText = FC<LinkTextProps> { props ->
    StyledLinkText {
        css(props.className) {}
        +props.children
    }
}

private val StyledLink = a.styled { _, _ ->
    textDecoration = None.none
    cursor = Cursor.pointer
}

private val StyledLinkText = span.styled { _, _ ->
    textDecoration = TextDecoration.underline
}
