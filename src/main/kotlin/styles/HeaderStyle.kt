package styles

import kotlinx.css.Display
import materialui.styles.StylesSet

val headerStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex
    }
    "appBar" {
        flexGrow = 1.0
    }
}
