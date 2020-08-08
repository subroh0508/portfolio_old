@file:Suppress("FunctionName")

package utilities

import react.RBuilder
import react.dom.a

fun RBuilder.Links(vararg links: Pair<String, String>) = links.forEachIndexed { i, (href, text) ->
    a {
        attrs.href = href
        attrs.target = "_blank"
        +text
    }
    if (i != links.size - 1) +"/"
}
