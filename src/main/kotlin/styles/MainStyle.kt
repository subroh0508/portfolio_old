package styles

import kotlinx.css.*
import kotlinx.css.FontWeight.Companion.w400
import materialui.styles.StylesSet

val mainStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex
        width = 100.pct
        flexDirection = FlexDirection.column
        alignItems = Align.center

        descendants(".grid-root") {
            display = Display.grid
            width = 100.pct
            gridTemplateColumns = GridTemplateColumns.repeat("12, ${1.fr}")
            gridAutoRows = GridAutoRows.minMax(300.px, LinearDimension.auto)

            children("div") {
                margin(vertical = (theme.spacing.unit * 4).px)
            }
        }
    }
}

val aboutStyle: StylesSet.() -> Unit = {
    "cardRoot" {
        gridColumnStart = GridColumnStart("3")
        gridColumnEnd = GridColumnEnd("11")

        descendants(".divider") {
            backgroundColor = Color("#e33830")
        }
    }
    "cardContent" {
        display = Display.flex
        alignItems = Align.center
    }
    "avatar" {
        height = 240.px
        width = 240.px
    }
    "paragraph" {
        paddingLeft = 16.px

        children("p") {
            fontWeight = w400
            fontSize = 1.20.rem

            firstChild {
                paddingBottom = 16.px
            }
        }
    }
}
