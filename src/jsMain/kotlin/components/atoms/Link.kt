@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import csstype.Cursor
import csstype.None
import csstype.TextDecoration
import emotion.react.css
import emotion.styled.styled
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.A
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

@Composable
fun Link(
    href: String,
    target: ATarget = ATarget.Blank,
    content: @Composable () -> Unit,
) {
    Style(LinkStyle)

    A(href, { target(target) }) {
        content()
    }
}

private object LinkStyle : StyleSheet() {
    init {
        "a" style {
            textDecoration("none")
            cursor("pointer")
            color(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
        }
    }
}

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
