package styles

import kotlinx.css.*
import materialui.styles.StylesSet

val biographyStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex
        width = 100.pct
        flexDirection = FlexDirection.column
        alignItems = Align.center

        children("div") {
            margin((theme.spacing.unit * 4).px)
        }
    }
}

val aboutStyle: StylesSet.() -> Unit = {
    "cardContent" {
        display = Display.flex
        maxWidth = 720.px
        alignItems = Align.center
    }
    "avatar" {
        height = 240.px
        width = 240.px
    }
    "paragraph" {
        paddingLeft = 16.px

        children("p") {
            firstChild {
                paddingBottom = 16.px
            }
        }
    }
}


val profileStyle: StylesSet.() -> Unit = {
    "cardContent" {
        display = Display.flex
        maxWidth = 640.px
        alignItems = Align.center
    }
    "paragraph" {

    }
}
