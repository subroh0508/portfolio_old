@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.css.properties.borderBottom
import kotlinx.html.TR
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.RBuilder
import styled.StyledDOMBuilder
import styled.css
import styled.styledTr

fun RBuilder.TableRow(handler: StyledDOMBuilder<TR>.() -> Unit) = styledTr {
    css {
        td {
            position = Position.relative

            after {
                content = "".quoted
                position = Position.absolute
                left = 0.px
                right = 0.px
                bottom = 0.px
                borderBottom(1.px, BorderStyle.solid, Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty()))
            }
        }
    }

    handler()
}
