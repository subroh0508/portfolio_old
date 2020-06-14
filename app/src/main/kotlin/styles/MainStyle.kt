package styles

import components.MainProps
import components.biography.AboutProps
import kotlinx.css.*
import materialui.styles.StylesBuilder

val mainStyle: StylesBuilder<MainProps>.() -> Unit = {
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
                margin(vertical = (theme.spacing(4)).px)
            }
        }
    }
}

val aboutStyle: StylesBuilder<AboutProps>.() -> Unit = {
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
            fontWeight = FontWeight.w400
            fontSize = 1.20.rem

            firstChild {
                paddingBottom = 16.px
            }
        }
    }
}
