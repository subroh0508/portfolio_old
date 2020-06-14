package styles

import components.links.LinksProps
import kotlinx.css.*
import materialui.styles.StylesBuilder
import materialui.styles.palette.secondary

val linksStyle: StylesBuilder<LinksProps>.() -> Unit = {
    "root" {
        display = Display.flex
        width = 100.pct
        flexDirection = FlexDirection.column
        alignItems = Align.center

        descendants(".grid-root") {
            display = Display.grid
            backgroundColor = Color("#fafafa")
            padding((theme.spacing(2)).px)
            width = 100.pct
            gridTemplateColumns = GridTemplateColumns.repeat("12, ${1.fr}")
            gridAutoRows = GridAutoRows.minMax(300.px, LinearDimension.auto)
            gap = Gap(8.px.toString())

            children("a") {
                textTransform = TextTransform.none

                (1..3).forEach {
                    nthChild("$it") {
                        gridColumn = GridColumn("${3 + (it - 1) * 3} / span 2")
                    }
                }

                descendants(".label") {
                    color = theme.palette.text.secondary
                }
            }

            descendants("svg") {
                marginRight = 8.px
            }
        }
    }
}
