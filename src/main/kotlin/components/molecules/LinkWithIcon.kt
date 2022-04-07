@file:Suppress("FunctionName")

package components.molecules

import components.atoms.Link
import components.atoms.LinkProps
import components.atoms.Subtitle
import components.atoms.SubtitleProps
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.css.properties.TextDecorationLine
import kotlinx.html.SPAN
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.FC
import react.fc
import react.RBuilder
import styled.*

external interface LinkWithIconProps : LinkProps {
    var display: String
    var icon: FC<StyledProps>
}

val LinkWithIcon = fc<LinkWithIconProps> { props ->
    StyledLink(props.className.unsafeCast<String>()) {
        attrs.href = props.href
        attrs.target = props.target

        StyledLinkSpan {
            StyledLinkIcon(props.icon)
            StyledLinkTypography { attrs.subtitle = props.display }
        }
    }
}

private fun RBuilder.StyledLink(className: String? = null, handler: StyledHandler<LinkProps>) = (styled(Link)) {
    css {
        className?.let(classes::add)
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    handler()
}

private fun RBuilder.StyledLinkSpan(handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        display = Display.flex
        alignItems = Align.center
    }

    handler()
}

private fun RBuilder.StyledLinkIcon(icon: FC<StyledProps>) = (styled(icon)) {
    css {
        marginRight = 8.px

        hover { textDecoration = TextDecoration.none }
    }
}

private fun RBuilder.StyledLinkTypography(handler: StyledHandler<SubtitleProps>) = (styled(Subtitle)) {
    css {
        marginTop = 0.px
        marginBottom = 0.px

        hover {
            textDecoration = TextDecoration(setOf(TextDecorationLine.underline))
        }
    }

    handler()

    attrs.tag = "span"
}
