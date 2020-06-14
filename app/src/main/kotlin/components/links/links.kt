package components.links

import components.MainProps
import components.root
import kotlinx.html.HTMLTag
import kotlinx.html.TagConsumer
import materialui.components.button.button
import materialui.components.button.enums.ButtonColor
import materialui.components.button.enums.ButtonVariant
import materialui.components.svgicon.svgIcon
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.ReactElement
import react.dom.RDOMBuilder
import react.dom.div
import react.dom.span
import react.dom.tag
import styles.linksStyle

val RBuilder.links
    get() = childWithStyles("Links", linksStyle) { props ->
        div(props.root) {
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                +"もれなくどこかに出没しています...( ˘ω˘)"
            }

            div("grid-root") {
                button {
                    attrs.variant = ButtonVariant.contained
                    attrs.color = ButtonColor.secondary
                    attrs.href = "https://twitter.com/subroh_0508"
                    attrs["target"] = "_blank"

                    twitterLogo
                    span("label") { +"Twitter" }
                }

                button {
                    attrs.variant = ButtonVariant.contained
                    attrs.color = ButtonColor.secondary
                    attrs.href = "https://imastodon.net/@subroh_0508"
                    attrs["target"] = "_blank"

                    mastodonLogo
                    span("label") { +"iM@STODON" }
                }

                button {
                    attrs.variant = ButtonVariant.contained
                    attrs.color = ButtonColor.secondary
                    attrs.href = "https://github.com/subroh0508"
                    attrs["target"] = "_blank"

                    githubLogo
                    span("label") { +"Github" }
                }
            }
        }
    }

val RBuilder.twitterLogo
    get() = svgIcon {
        path {
            attrs.d = "M7.6 21.63c8.95 0 13.84-7.4 13.84-13.84v-.63c.94-.7 1.76-1.55 2.4-2.52-.86.38-1.8.64-2.78.76 1-.6 1.78-1.54 2.14-2.68-.94.56-1.98.96-3.1 1.18-.88-.94-2.14-1.53-3.54-1.53-2.7 0-4.86 2.17-4.86 4.86 0 .38.04.75.12 1.1C7.78 8.14 4.2 6.2 1.8 3.27c-.42.72-.66 1.55-.66 2.44 0 1.7.86 3.18 2.16 4.05-.8-.02-1.55-.24-2.2-.6v.05c0 2.36 1.67 4.33 3.9 4.77-.4.1-.84.17-1.28.17-.32 0-.62-.03-.92-.08.62 1.93 2.42 3.33 4.55 3.37-1.67 1.3-3.76 2.1-6.04 2.1-.4 0-.77-.04-1.15-.08 2.15 1.38 4.7 2.18 7.45 2.18"
        }
    }

val RBuilder.mastodonLogo
    get() = svgIcon {
        attrs.viewBox = "0 0 216.4144 232.00976"

        path {
            attrs.d = "M211.80734 139.0875c-3.18125 16.36625-28.4925 34.2775-57.5625 37.74875-15.15875 1.80875-30.08375 3.47125-45.99875 2.74125-26.0275-1.1925-46.565-6.2125-46.565-6.2125 0 2.53375.15625 4.94625.46875 7.2025 3.38375 25.68625 25.47 27.225 46.39125 27.9425 21.11625.7225 39.91875-5.20625 39.91875-5.20625l.8675 19.09s-14.77 7.93125-41.08125 9.39c-14.50875.7975-32.52375-.365-53.50625-5.91875C9.23234 213.82 1.40609 165.31125.20859 116.09125c-.365-14.61375-.14-28.39375-.14-39.91875 0-50.33 32.97625-65.0825 32.97625-65.0825C49.67234 3.45375 78.20359.2425 107.86484 0h.72875c29.66125.2425 58.21125 3.45375 74.8375 11.09 0 0 32.975 14.7525 32.975 65.0825 0 0 .41375 37.13375-4.59875 62.915"
        }
        path {
            attrs.d = "M177.50984 80.077v60.94125h-24.14375v-59.15c0-12.46875-5.24625-18.7975-15.74-18.7975-11.6025 0-17.4175 7.5075-17.4175 22.3525v32.37625H96.20734V85.42325c0-14.845-5.81625-22.3525-17.41875-22.3525-10.49375 0-15.74 6.32875-15.74 18.7975v59.15H38.90484V80.077c0-12.455 3.17125-22.3525 9.54125-29.675 6.56875-7.3225 15.17125-11.07625 25.85-11.07625 12.355 0 21.71125 4.74875 27.8975 14.2475l6.01375 10.08125 6.015-10.08125c6.185-9.49875 15.54125-14.2475 27.8975-14.2475 10.6775 0 19.28 3.75375 25.85 11.07625 6.36875 7.3225 9.54 17.22 9.54 29.675"
            attrs.fill = "#99b7dc"
        }
    }

val RBuilder.githubLogo
    get() = svgIcon {
        path {
            attrs.d = "M12 .3a12 12 0 0 0-3.8 23.4c.6.1.8-.3.8-.6v-2c-3.3.7-4-1.6-4-1.6-.6-1.4-1.4-1.8-1.4-1.8-1-.7.1-.7.1-.7 1.2 0 1.9 1.2 1.9 1.2 1 1.8 2.8 1.3 3.5 1 0-.8.4-1.3.7-1.6-2.7-.3-5.5-1.3-5.5-6 0-1.2.5-2.3 1.3-3.1-.2-.4-.6-1.6 0-3.2 0 0 1-.3 3.4 1.2a11.5 11.5 0 0 1 6 0c2.3-1.5 3.3-1.2 3.3-1.2.6 1.6.2 2.8 0 3.2.9.8 1.3 1.9 1.3 3.2 0 4.6-2.8 5.6-5.5 5.9.5.4.9 1 .9 2.2v3.3c0 .3.1.7.8.6A12 12 0 0 0 12 .3"
        }
    }

inline fun RBuilder.path(block: RDOMBuilder<PATH>.() -> Unit): ReactElement = tag(block) { PATH(it) }

class PATH(override val consumer : TagConsumer<*>): HTMLTag("path", consumer, mapOf(), null, false, false) {
    var d: String by attributes
    var fill: String by attributes
}
