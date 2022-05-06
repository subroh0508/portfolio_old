package themes

import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.StyleSheet

object MaterialTheme : StyleSheet() {
    init {
        type(":root") style {
            property("--mdc-theme-primary", Color("#0D386D"))
            property("--mdc-theme-surface", Color("#0D386D"))
            property("--mdc-theme-background", Color("#121212"))
            property("--mdc-theme-text-primary-on-dark", Color("#99B7DC"))
            property("--mdc-theme-text-secondary-on-dark", Color("#3B91C4"))
        }
    }
}