@file:Suppress("FunctionName")

import components.templates.IntroductionNameCard
import react.dom.render
import kotlin.browser.document
import kotlinx.css.*
import react.child
import styled.*

fun main() {
    injectGlobal {
        body {
            backgroundColor = Color("#121212")
        }
    }

    render(document.getElementById("root")) {
        child(IntroductionNameCard) {
            attrs.name = "にしこりさぶろ〜"
            attrs.subName = "Subroh Nishikori"
        }
    }
}
