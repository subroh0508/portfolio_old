@file:Suppress("FunctionName")

import kotlinx.browser.document
import react.dom.render
import kotlinx.css.*
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import materialcomponents.VAR_COLOR_TEXT_SECONDARY_ON_DARK
import react.Props
import react.createElement
import react.dom.client.createRoot
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

    val root = document.getElementById("root") ?: return
    createRoot(root).render(createElement<Props> { ThemeProvider { routing() } })
}
