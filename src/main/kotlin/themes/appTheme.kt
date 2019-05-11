package themes

import kotlinx.css.Color
import materialui.styles.createMuiTheme
import materialui.styles.muitheme.MuiTheme
import materialui.styles.muitheme.options.palette
import materialui.styles.palette.options.*

val appTheme: MuiTheme = createMuiTheme {
    palette {
        primary {
            main = Color("#99b7dc")
            light = Color("#cbe9ff")
            dark = Color("#6987aa")
            contrastText = Color("#000")
        }
        secondary {
            main = Color("#6bb6b0")
            light = Color("#9ce8e2")
            dark = Color("#3a8681")
            contrastText = Color("#000")
        }
    }
}
