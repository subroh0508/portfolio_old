@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Paragraph
import components.atoms.TableRow
import csstype.Color
import csstype.Margin
import csstype.px
import emotion.react.css
import emotion.styled.styled
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.*
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.table
import react.dom.html.ReactHTML.tbody
import react.dom.html.ReactHTML.td

external interface SkillRowProps : PropsWithChildren, PropsWithClassName {
    var name: String
    var stars: Int
    var since: String
}

val SkillTable = FC<PropsWithChildren> { props ->
    StyledTable {
        tbody { +props.children }
    }
}

val SkillRow = FC<SkillRowProps> { props ->
    val stars = ((0..4).joinToString("") { i -> if (i < props.stars) "★" else "☆" })

    StyledTableRow {
        td { +props.name }
        td { +stars }
        td { +"${props.since}-" }
    }

    StyledTableRowParagraph {
        +props.children
    }
}

private val StyledTable = table.styled { _, _ ->
    borderSpacing = 0.px
}

private val StyledTableRow = TableRow.styled { _, _ ->
    color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")

    td {
        paddingTop = 8.px
    }
}

private val StyledTableRowParagraph = FC<PropsWithChildren> { props ->
    TableRow {
        css {
            p {
                margin = Margin(8.px, 0.px)
            }
        }

        td {
            colSpan = 3

            Paragraph {
                +props.children
            }
        }
    }
}
