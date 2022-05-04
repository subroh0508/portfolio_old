@file:Suppress("FunctionName")

import emotion.react.Global
import emotion.react.styles
import kotlinx.browser.document
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import materialcomponents.VAR_COLOR_TEXT_SECONDARY_ON_DARK
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.renderComposable
import react.*
import react.dom.client.createRoot
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.body
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.html
import react.dom.html.ReactHTML.p
import themes.ThemeProvider

fun main() {
    renderComposable(rootElementId = GlobalStyleSheet.ELEMENT_ID) {
        Style(GlobalStyleSheet)
    }
    val root = document.getElementById("root") ?: return
    createRoot(root).render(
        GlobalStyled {
            ThemeProvider { +routing }
        },
    )
}

object GlobalStyleSheet : StyleSheet() {
    const val ELEMENT_ID = "root"

    init {
        type("html") style  {
            height(100.percent)
            margin(0.px)
        }
        type("body") style {
            height(100.percent)
            margin(0.px)
            backgroundColor(Color("#121212"))
        }
        type("style") style  {
            margin(0.px)
        }
        type("div") style {
            id(ELEMENT_ID) style {
                height(100.percent)
            }
        }
        type("p") style  {
            type("a") style {
                color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
            }
        }
        type("hr") style  {
            height(1.px)
            backgroundColor(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
            border(0.px)
        }
    }
}

private fun GlobalStyled(block: ChildrenBuilder.() -> Unit) = VFC {
    Global {
        styles {
            html {
                height = 100.pct
                margin = Margin(0.px, 0.px)
            }

            body {
                height = 100.pct
                margin = Margin(0.px, 0.px)
                backgroundColor = Color("#121212")
            }
            "div#root" {
                height = 100.pct
            }
            p {
                a { color = Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)") }
            }
            hr {
                height = 1.px
                backgroundColor = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
                border = 0.px
            }
        }
    }

    block()
}.create()
