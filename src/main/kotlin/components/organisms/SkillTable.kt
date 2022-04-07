@file:Suppress("FunctionName")

package components.organisms

import components.atoms.Paragraph
import components.atoms.TableRow
import kotlinx.css.*
import kotlinx.css.p as cssP
import kotlinx.css.td as cssTd
import kotlinx.html.TABLE
import kotlinx.js.jso
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import react.*
import react.dom.*
import styled.StyledProps
import styled.css
import styled.styledTable
import styled.styledTd

external interface SkillRowProps : StyledProps {
    var name: String
    var stars: Int
    var since: String
}

fun RBuilder.SkillTable(vararg handler: RHandler<SkillRowProps>) = StyledTable {
    tbody { handler.forEach { h -> SkillRow(h) } }
}

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
private fun RBuilder.SkillRow(handler: RHandler<SkillRowProps>) {
    val builder = SkillTableElementBuilder().apply(handler)
    val attrs = builder.attrs

    StyledTableRow {
        td { +attrs.name }
        td { +((0..4).joinToString("") { i -> if (i < attrs.stars) "★" else "☆" }) }
        td { +"${attrs.since}-" }
    }

    StyledTableRowParagraph { childList.addAll(builder.childList) }
}

private class SkillTableElementBuilder : RElementBuilderImpl<SkillRowProps>(jso { })

private fun RBuilder.StyledTable(handler: RDOMBuilder<TABLE>.() -> Unit) = styledTable {
    css { borderSpacing = 0.px }

    handler()
}

private fun RBuilder.StyledTableRow(handler: RBuilder.() -> Unit) = TableRow {
    css {
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())

        cssTd {
            paddingTop = 8.px
        }
    }

    handler()
}

private fun RBuilder.StyledTableRowParagraph(handler: RBuilder.() -> Unit) = TableRow {
    styledTd {
        css {
            cssP { margin(8.px, 0.px) }
        }
        attrs { colSpan = "3" }

        child(Paragraph) { handler() }
    }
}
