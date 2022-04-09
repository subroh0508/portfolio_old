@file:Suppress("FunctionName")

package utilities

import react.ChildrenBuilder
import react.dom.html.AnchorTarget
import react.dom.html.ReactHTML.a

fun ChildrenBuilder.Links(vararg links: Pair<String, String>) = links.forEachIndexed { i, (url, text) ->
    a {
        href = url
        target = AnchorTarget._blank

        +text
    }
    if (i != links.size - 1) +"/"
}
