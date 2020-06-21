@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Link
import components.atoms.LinkProps
import components.atoms.Subtitle
import components.atoms.SubtitleProps
import kotlinx.css.*
import kotlinx.html.DIV
import materialcomponents.TypographyProps
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.dom.div
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.StyledHandler
import styled.css
import styled.styledDiv
import utilities.styled

external interface NameCardLinksProps : WithClassName {
    var homepage: String
    var twitter: String
    var github: String
    var email: String
}

val NameCardLinks = functionalComponent<NameCardLinksProps> { props ->
    StyledLinksRoot {
        StyledLink {
            attrs.href = "https://suroh0508.net"

            StyledLinkTypography { attrs.subtitle = props.homepage }
        }

        StyledLink {
            attrs.href = "https://twiter.com/subroh_0508"

            StyledLinkTypography { attrs.subtitle = props.twitter }
        }

        StyledLink {
            attrs.href = "https://github.com/subroh0508"

            StyledLinkTypography { attrs.subtitle = props.github }
        }

        StyledLink {
            attrs.href = "mailto://${props.email}"

            StyledLinkTypography { attrs.subtitle = props.email }
        }
    }
}

private fun RBuilder.StyledLinksRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        margin(LinearDimension.auto, LinearDimension.auto, 24.px, 24.px)
    }

    handler()
}

private fun RBuilder.StyledLink(handler: StyledHandler<LinkProps>) = (styled(Link)) {
    css {
        display = Display.block
    }

    handler()
}

private fun RBuilder.StyledLinkTypography(handler: StyledHandler<SubtitleProps>) = (styled(Subtitle)) {
    css {
        marginTop = 0.px
        marginBottom = 0.px
    }

    handler()

    attrs.tag = "span"
}
