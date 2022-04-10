@file:Suppress("FunctionName")

package components.molecules

import components.atoms.Link
import components.atoms.LinkProps
import components.atoms.Subtitle
import components.atoms.SubtitleProps
import csstype.*
import emotion.css.cx
import emotion.react.css
import emotion.styled.styled
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.*
import react.dom.html.ReactHTML.span

external interface LinkWithIconProps : LinkProps {
    var display: String
    var icon: FC<PropsWithClassName>
}

val LinkWithIcon = FC<LinkWithIconProps> { props ->
    StyledLink {
        href = props.href
        target = props.target

        StyledLinkSpan {
            +StyledLinkIcon(props.icon)
            StyledLinkTypography { subtitle = props.display }
        }
    }
}

private val StyledLink = Link.styled { props, _ ->
    cx(props.className)
    color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
}

private val StyledLinkSpan = span.styled { _, _ ->
    display = Display.flex
    alignItems = AlignItems.center
}

private fun StyledLinkIcon(icon: FC<PropsWithClassName>) = icon.styled { _, _ ->
    marginRight = 8.px

    hover { textDecoration = None.none }
}.create()

private val StyledLinkTypography = FC<SubtitleProps> { props ->
    Subtitle {
        css {
            marginTop = 0.px
            marginBottom = 0.px

            hover {
                textDecoration = TextDecoration.underline
            }
        }

        subtitle = props.subtitle
        tag = "span"
    }
}
