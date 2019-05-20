
import components.biography.biography
import components.header.AppFrame
import components.links.links
import components.works.work
import materialui.styles.childWithStyles
import materialui.styles.muithemeprovider.muiThemeProvider
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styles.appFrameStyle
import themes.appTheme

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        muiThemeProvider(appTheme) {
            childWithStyles(AppFrame::class, appFrameStyle) {
                attrs.views = listOfNotNull(
                    biography { },
                    work { },
                    links { }
                ).toTypedArray()
            }
        }
    }
}