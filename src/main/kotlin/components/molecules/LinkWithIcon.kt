@file:Suppress("FunctionName")

package components.molecules

import components.atoms.Link
import components.atoms.LinkProps
import components.atoms.Subtitle
import components.atoms.SubtitleProps
import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import kotlinx.html.SPAN
import react.FunctionalComponent
import react.RBuilder
import react.dom.WithClassName
import react.dom.span
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.StyledHandler
import styled.css
import styled.styledSpan
import utilities.styled

external interface LinkWithIconProps : LinkProps {
    var display: String
    var icon: FunctionalComponent<WithClassName>
}

val LinkWithIcon = functionalComponent<LinkWithIconProps> { props ->
    StyledLink(props.className) {
        attrs.href = props.href
        attrs.target = props.target

        StyledLinkSpan {
            StyledLinkIcon(props.icon)
            StyledLinkTypography { attrs.subtitle = props.display }
        }
    }
}

private fun RBuilder.StyledLink(className: String? = null, handler: StyledHandler<LinkProps>) = (styled(Link)) {
    css { className?.let(classes::add) }

    handler()
}

private fun RBuilder.StyledLinkSpan(handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        display = Display.flex
        alignItems = Align.center
    }

    handler()
}

private fun RBuilder.StyledLinkIcon(icon: FunctionalComponent<WithClassName>) = (styled(icon)) {
    css {
        marginRight = 4.px

        hover { textDecoration = TextDecoration.none }
    }
}

private fun RBuilder.StyledLinkTypography(handler: StyledHandler<SubtitleProps>) = (styled(Subtitle)) {
    css {
        marginTop = 0.px
        marginBottom = 0.px
    }

    handler()

    attrs.tag = "span"
}
