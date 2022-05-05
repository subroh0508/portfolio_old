@file:Suppress("FunctionName")

package components.organisms.introduction

import androidx.compose.runtime.Composable
import components.atoms.*
import components.molecules.LinkWithIcon
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span

@Composable
fun NameCardLinks(
    homepage: String,
    twitter: String,
    github: String,
    email: String,
) {
    Style(NameCardLinksStyle)

    Div({ classes(NameCardLinksStyle.container) }) {
        LinkWithIcon(
            PROTOCOL_HTTPS + homepage,
            homepage,
        ) { className -> ComposableHomeIcon(className) }

        Span({ classes(NameCardLinksStyle.row) }) {
            LinkWithIcon(
                "$PROTOCOL_HTTPS$DOMAIN_TWITTER/$twitter",
                twitter,
            ) { className -> ComposableTwitterIcon(className) }

            LinkWithIcon(
                "$PROTOCOL_HTTPS$DOMAIN_GITHUB/$github",
                github,
            ) { className -> ComposableGitHubIcon(className) }
        }

        LinkWithIcon(
            PROTOCOL_MAIL + email,
            email,
        ) { className -> ComposableEMailIcon(className) }
    }
}

private const val PROTOCOL_HTTPS = "https://"
private const val PROTOCOL_MAIL = "mailto://"
private const val DOMAIN_TWITTER = "twitter.com"
private const val DOMAIN_GITHUB = "github.com"

private object NameCardLinksStyle : StyleSheet() {
    val container by style {
        property("margin", "auto 0 24px 24px")
    }

    val row by style {
        display(DisplayStyle.Flex)
        type("a") style {
            marginRight(12.px)
        }
    }

    val linkWithIcon by style {
        property("margin-right", "auto")
    }
}
