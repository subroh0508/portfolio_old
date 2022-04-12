@file:Suppress("FunctionName")

package components.atoms

import csstype.*
import emotion.styled.styled
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.dom.html.ReactHTML.td
import react.dom.html.ReactHTML.tr

val TableRow = tr.styled { _, _ ->
    td {
        position = Position.relative

        after {
            asDynamic()["content"] = "''"
            position = Position.absolute
            left = 0.px
            right = 0.px
            bottom = 0.px
            borderBottom = Border(1.px, LineStyle.solid, Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
        }
    }
}
