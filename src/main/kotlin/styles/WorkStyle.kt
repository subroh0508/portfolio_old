package styles

import kotlinx.css.*
import materialui.styles.StylesSet

val projectStyle: StylesSet.() -> Unit = {
    "cardRoot" {
        gridColumnStart = GridColumnStart("1")
        gridColumnEnd = GridColumnEnd("13")

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

val speakStyle: StylesSet.() -> Unit = {
    "cardRoot" {
        gridColumnStart = GridColumnStart("1")
        gridColumnEnd = GridColumnEnd("13")

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
