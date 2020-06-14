package styles

import components.header.AppFrameProps
import kotlinx.css.*
import materialui.styles.StylesBuilder
import materialui.styles.palette.default
import materialui.styles.palette.main
import materialui.styles.typography.typography

val appFrameStyle: StylesBuilder<AppFrameProps>.() -> Unit = {
    "root" {
        display = Display.flex
        background = theme.palette.background.default.toString()
    }
    "appBar" {
        flexGrow = 1.0
        padding(horizontal = (theme.spacing(6)).px)
    }
    "toolbar" {
        flexDirection = FlexDirection.column
        alignItems = Align.flexStart
        padding(top = (theme.spacing(3)).px, bottom = (theme.spacing(5)).px)
    }
    "title" {
        paddingBottom = 4.px
    }
    "subtitle" {
        typography(theme.typography.caption)
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
        background = theme.palette.background.default.toString()
        width = 100.pct
        position = Position.relative
        top = 176.px
        padding(horizontal = (theme.spacing(9)).px)
    }
}
