
import components.biography.biography
import components.header.AppFrame
import materialui.styles.childWithStyles
import materialui.styles.muithemeprovider.muiThemeProvider
import react.*
import styles.appFrameStyle
import themes.appTheme

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        muiThemeProvider(appTheme) {
            childWithStyles(AppFrame::class, appFrameStyle) {
                attrs.views = listOfNotNull(
                    biography { },
                    buildElement { +"works" },
                    buildElement { +"links" }
                ).toTypedArray()
            }
        }
    }
}