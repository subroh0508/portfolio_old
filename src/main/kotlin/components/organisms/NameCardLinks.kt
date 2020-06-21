@file:Suppress("FunctionName")

package components.organisms

import components.atoms.*
import components.molecules.LinkWithIcon
import components.molecules.LinkWithIconProps
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.dom.WithClassName
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
        StyledLinkWithIcon {
            attrs.href = "https://suroh0508.net"
            attrs.display = props.homepage
            attrs.icon = HomeIcon
        }

        StyledLinkWithIcon {
            attrs.href = "https://twiter.com/subroh_0508"
            attrs.display = props.twitter
            attrs.icon = TwitterIcon
        }

        StyledLinkWithIcon {
            attrs.href = "https://github.com/subroh0508"
            attrs.display = props.github
            attrs.icon = GitHubIcon
        }

        StyledLinkWithIcon {
            attrs.href = "mailto://${props.email}"
            attrs.display = props.email
            attrs.icon = EmailIcon
        }
    }
}

private fun RBuilder.StyledLinksRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        margin(LinearDimension.auto, LinearDimension.auto, 24.px, 24.px)
    }

    handler()
}

private fun RBuilder.StyledLinkWithIcon(handler: StyledHandler<LinkWithIconProps>) = (styled(LinkWithIcon)) {
    css {
        display = Display.flex
    }

    handler()
}
