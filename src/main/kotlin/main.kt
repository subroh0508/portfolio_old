@file:Suppress("FunctionName")

import components.templates.AppFrame
import components.templates.IntroductionNameCard
import react.dom.render
import kotlin.browser.document
import kotlinx.css.*
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
    }

    render(document.getElementById("root")) {
        ThemeProvider {
            child(AppFrame) {
                child(IntroductionNameCard) {}
            }
        }
    }
}
