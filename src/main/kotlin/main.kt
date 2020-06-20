@file:Suppress("FunctionName")

import components.templates.IntroductionNameCard
import react.dom.render
import kotlin.browser.document
import kotlinext.js.require
import kotlinx.css.*
import react.child
import styled.*

fun main() {
    injectGlobal {
        body {
            backgroundColor = Color("#121212")
        }
    }

    require("@material/card/dist/mdc.card.min.css")
    require("@material/typography/dist/mdc.typography.min.css")
    require("@material/theme/dist/mdc.theme.min.css")

    render(document.getElementById("root")) {
        child(IntroductionNameCard) {
            attrs.name = "にしこりさぶろ〜"
            attrs.subName = "Subroh Nishikori"
        }
    }
}
