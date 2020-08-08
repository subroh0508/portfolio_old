@file:Suppress("FunctionName")

import components.atoms.Footer
import components.templates.*
import react.dom.render
import kotlin.browser.document
import kotlinx.css.*
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import materialcomponents.VAR_COLOR_TEXT_SECONDARY_ON_DARK
import react.child
import styled.*
import themes.ThemeProvider

fun main() {
    injectGlobal {
        html {
            height = 100.pct
            margin(0.px)
        }
        body {
            height = 100.pct
            margin(0.px)
            backgroundColor = Color("#121212")
        }
        "div#root" {
            height = 100.pct
        }
        p {
            a { color = Color(VAR_COLOR_TEXT_SECONDARY_ON_DARK.toCustomProperty()) }
        }
        hr {
            height = 1.px
            backgroundColor = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
            border = "0"
        }
    }

    render(document.getElementById("root")) {
        ThemeProvider {
            child(AppFrame) {
                child(IntroductionNameCard)
                child(BiographyCard)
                child(SkillCard)
                child(WorksCard)
                child(SpeaksCard)
                child(LinksCard)
                child(Footer)
            }
        }
    }
}
