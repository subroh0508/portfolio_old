
import components.header.appHeader
import materialui.styles.muithemeprovider.muiThemeProvider
import react.dom.render
import themes.appTheme
import kotlin.browser.document

fun main() {
    render(document.getElementById("root")) {
        muiThemeProvider(appTheme) {
            appHeader { }
        }
    }
}
