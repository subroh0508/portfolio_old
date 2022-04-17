@file:Suppress("FunctionName")

package components.organisms.introduction

import components.atoms.*
import components.molecules.LinkWithIcon
import csstype.Auto
import csstype.Display
import csstype.Margin
import csstype.px
import emotion.styled.styled
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Span
import org.w3c.dom.HTMLElement
import react.FC
import react.PropsWithClassName
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span
import react.useRef
import utilities.ref
import utilities.useCompose

external interface NameCardLinksProps : PropsWithClassName {
    var homepage: String
    var twitter: String
    var github: String
    var email: String
}

val NameCardLinks = FC<NameCardLinksProps> { props ->
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        Style(NameCardLinksStyle)

        LinkWithIcon(
            PROTOCOL_HTTPS + props.homepage,
            props.homepage,
        ) { className -> ComposableHomeIcon(className) }

        Span({ classes(NameCardLinksStyle.row) }) {
            LinkWithIcon(
                "$PROTOCOL_HTTPS$DOMAIN_TWITTER/${props.twitter}",
                props.twitter,
            ) { className -> ComposableTwitterIcon(className) }

            LinkWithIcon(
                "$PROTOCOL_HTTPS$DOMAIN_GITHUB/${props.github}",
                props.github,
            ) { className -> ComposableGitHubIcon(className) }
        }

        LinkWithIcon(
            PROTOCOL_MAIL + props.email,
            props.email,
        ) { className -> ComposableEMailIcon(className) }
    }

    StyledLinksRoot {
        ref { containerRef.current = it }
    }
}

private const val PROTOCOL_HTTPS = "https://"
private const val PROTOCOL_MAIL = "mailto://"
private const val DOMAIN_TWITTER = "twitter.com"
private const val DOMAIN_GITHUB = "github.com"

private val StyledLinksRoot = div.styled { _, _ ->
    margin = Margin(Auto.auto, 0.px, 24.px, 24.px)
}
private object NameCardLinksStyle : StyleSheet() {
    val row by style {
        display(DisplayStyle.Flex)
        "a" {
            marginRight(CSSUnitValueTyped(12.toFloat(), CSSUnit.px))
        }
    }

    val linkWithIcon by style {
        property("margin-right", "auto")
    }
}
