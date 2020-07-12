@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.*
import components.molecules.LinkWithIcon
import components.molecules.LinkWithIconProps
import kotlinx.css.*
import kotlinx.html.DIV
import kotlinx.html.SPAN
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.*
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
            attrs.href = PROTOCOL_HTTPS + props.homepage
            attrs.display = props.homepage
            attrs.icon = HomeIcon
        }

        StyledRowSpan {
            StyledLinkWithIcon {
                attrs.href = "$PROTOCOL_HTTPS$DOMAIN_TWITTER/${props.twitter}"
                attrs.display = props.twitter
                attrs.icon = TwitterIcon
            }

            StyledLinkWithIcon {
                attrs.href = "$PROTOCOL_HTTPS$DOMAIN_GITHUB/${props.github}"
                attrs.display = props.github
                attrs.icon = GitHubIcon
            }
        }

        StyledLinkWithIcon {
            attrs.href = PROTOCOL_MAIL + props.email
            attrs.display = props.email
            attrs.icon = EmailIcon
        }
    }
}

private const val PROTOCOL_HTTPS = "https://"
private const val PROTOCOL_MAIL = "mailto://"
private const val DOMAIN_TWITTER = "twitter.com"
private const val DOMAIN_GITHUB = "github.com"

private fun RBuilder.StyledLinksRoot(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        margin(LinearDimension.auto, 0.px, 24.px, 24.px)
    }

    handler()
}

private fun RBuilder.StyledRowSpan(handler: StyledDOMBuilder<SPAN>.() -> Unit) = styledSpan {
    css {
        display = Display.flex

        children(a.tagName) {
            marginRight = 12.px
        }
    }

    handler()
}

private fun RBuilder.StyledLinkWithIcon(handler: StyledHandler<LinkWithIconProps>) = (styled(LinkWithIcon)) {
    css {
        marginRight = LinearDimension.auto
    }

    handler()
}
