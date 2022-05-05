@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.ExperimentalComposeWebSvgApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.I
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.svg.Path
import org.jetbrains.compose.web.svg.Svg

private const val D_TWITTER = "M7.6 21.63c8.95 0 13.84-7.4 13.84-13.84v-.63c.94-.7 1.76-1.55 2.4-2.52-.86.38-1.8.64-2.78.76 1-.6 1.78-1.54 2.14-2.68-.94.56-1.98.96-3.1 1.18-.88-.94-2.14-1.53-3.54-1.53-2.7 0-4.86 2.17-4.86 4.86 0 .38.04.75.12 1.1C7.78 8.14 4.2 6.2 1.8 3.27c-.42.72-.66 1.55-.66 2.44 0 1.7.86 3.18 2.16 4.05-.8-.02-1.55-.24-2.2-.6v.05c0 2.36 1.67 4.33 3.9 4.77-.4.1-.84.17-1.28.17-.32 0-.62-.03-.92-.08.62 1.93 2.42 3.33 4.55 3.37-1.67 1.3-3.76 2.1-6.04 2.1-.4 0-.77-.04-1.15-.08 2.15 1.38 4.7 2.18 7.45 2.18"
private const val D_GITHUB = "M12 .3a12 12 0 0 0-3.8 23.4c.6.1.8-.3.8-.6v-2c-3.3.7-4-1.6-4-1.6-.6-1.4-1.4-1.8-1.4-1.8-1-.7.1-.7.1-.7 1.2 0 1.9 1.2 1.9 1.2 1 1.8 2.8 1.3 3.5 1 0-.8.4-1.3.7-1.6-2.7-.3-5.5-1.3-5.5-6 0-1.2.5-2.3 1.3-3.1-.2-.4-.6-1.6 0-3.2 0 0 1-.3 3.4 1.2a11.5 11.5 0 0 1 6 0c2.3-1.5 3.3-1.2 3.3-1.2.6 1.6.2 2.8 0 3.2.9.8 1.3 1.9 1.3 3.2 0 4.6-2.8 5.6-5.5 5.9.5.4.9 1 .9 2.2v3.3c0 .3.1.7.8.6A12 12 0 0 0 12 .3"

@Composable
fun HomeIcon(className: String? = null) { MaterialIcon(className, "home") }

@Composable
fun EMailIcon(className: String? = null) { MaterialIcon(className, "email") }

@Composable
fun ChevronLeft(className: String? = null) { MaterialIcon(className, "chevron_left") }

@Composable
fun ChevronRight(className: String? = null) { MaterialIcon(className, "chevron_right") }

@Composable
fun TwitterIcon(className: String? = null) { SvgIcon(className, D_TWITTER) }

@Composable
fun GitHubIcon(className: String? = null) { SvgIcon(className, D_GITHUB) }

@Composable
private fun MaterialIcon(className: String? = null, icon: String) {
    I({
        classes(*listOfNotNull(className, "material-icons").toTypedArray())
    }) { Text(icon) }
}

@OptIn(ExperimentalComposeWebSvgApi::class)
@Composable
private fun SvgIcon(className: String? = null, d: String) {
    Svg("0 0 24 24", {
        className?.let { classes(it) }
        style {
            width(24.px)
            height(24.px)
            property("fill", "currentcolor")
        }
    }) {
        Path(d)
    }
}
