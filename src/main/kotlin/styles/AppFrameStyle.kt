package styles

import kotlinx.css.*
import materialui.styles.StylesSet
import materialui.styles.palette.main

val appFrameStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex
    }
    "appBar" {
        flexGrow = 1.0
    }
    "tabs" {
        justifyContent = JustifyContent.flexEnd
    }
    "tabsIndicator" {
        height = 3.px
        borderRadius = 1.px
        background = theme.palette.secondary.main.toString()
        margin(vertical = 10.px, horizontal = 30.px)
    }
    "contents" {
        position = Position.relative
        top = 112.px
    }
}
