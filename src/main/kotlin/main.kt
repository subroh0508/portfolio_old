
import kotlinx.html.*
import kotlinx.html.dom.append
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        document.getElementById("root")?.append {
            h3 {
                +"Subroh Nishikori's Portfolio"
            }
            ul {
                li {
                    span { +"Twitter: " }
                    a { href = "https://twitter.com/subroh_0508"; +"@subroh_0508" }
                }
                li {
                    span { +"Github: " }
                    a { href = "https://github.com/subroh0508"; + "@subroh0508" }
                }
            }
        }
    }
}