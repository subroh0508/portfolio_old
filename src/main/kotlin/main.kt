import kotlinx.html.dom.append
import kotlinx.html.js.div
import kotlinx.html.span
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        document.body!!.append.div {
            span {
                +"Hello World Again!"
            }
        }
    }
}