@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.EmailIcon
import components.atoms.GitHubIcon
import components.atoms.HomeIcon
import components.atoms.TwitterIcon
import components.molecules.LinkWithIcon
import csstype.Auto
import csstype.Display
import csstype.Margin
import csstype.px
import emotion.styled.styled
import react.FC
import react.PropsWithClassName
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span

external interface NameCardLinksProps : PropsWithClassName {
    var homepage: String
    var twitter: String
    var github: String
    var email: String
}

val NameCardLinks = FC<NameCardLinksProps> { props ->
    StyledLinksRoot {
        StyledLinkWithIcon {
            href = PROTOCOL_HTTPS + props.homepage
            display = props.homepage
            icon = HomeIcon
        }

        StyledRowSpan {
            StyledLinkWithIcon {
                href = "$PROTOCOL_HTTPS$DOMAIN_TWITTER/${props.twitter}"
                display = props.twitter
                icon = TwitterIcon
            }

            StyledLinkWithIcon {
                href = "$PROTOCOL_HTTPS$DOMAIN_GITHUB/${props.github}"
                display = props.github
                icon = GitHubIcon
            }
        }

        StyledLinkWithIcon {
            href = PROTOCOL_MAIL + props.email
            display = props.email
            icon = EmailIcon
        }
    }
}

private const val PROTOCOL_HTTPS = "https://"
private const val PROTOCOL_MAIL = "mailto://"
private const val DOMAIN_TWITTER = "twitter.com"
private const val DOMAIN_GITHUB = "github.com"

private val StyledLinksRoot = div.styled { _, _ ->
    margin = Margin(Auto.auto, 0.px, 24.px, 24.px)
}

private val StyledRowSpan = span.styled { _, _ ->
    display = Display.flex

    a {
        marginRight = 12.px
    }
}

private val StyledLinkWithIcon = LinkWithIcon.styled { _, _ ->
    marginRight = Auto.auto
}
