package themes

import kotlinx.css.Color
import materialui.styles.createMuiTheme
import materialui.styles.muitheme.MuiTheme
import materialui.styles.muitheme.options.palette
import materialui.styles.palette.options.*

val appTheme: MuiTheme = createMuiTheme {
    palette {
        primary {
            main = Color("#fff98e")
            light = Color("#ffffc0")
            dark = Color("#cac65e")
            contrastText = Color("#000")
        }
        secondary {
            main = Color("#99b7dc")
            light = Color("#cbe9ff")
            dark = Color("#6987aa")
            contrastText = Color("#000")
        }
    }
}
