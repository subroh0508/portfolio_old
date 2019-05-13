
import materialui.components.cssbaseline.cssBaseline
import react.dom.render
import kotlin.browser.document

fun main() {
    render(document.getElementById("root")) {
        cssBaseline {  }
        child(App::class) { }
    }
}
