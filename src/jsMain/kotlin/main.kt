@file:Suppress("FunctionName")

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.destroy
import com.arkivanov.essenty.lifecycle.resume
import kotlinx.browser.window
import materialcomponents.VAR_COLOR_TEXT_PRIMARY_ON_DARK
import materialcomponents.VAR_COLOR_TEXT_SECONDARY_ON_DARK
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.renderComposable
import routes.Router
import themes.MaterialTheme

fun main() {
    renderComposable(
        rootElementId = GlobalStyleSheet.ELEMENT_ID,
    ) { App() }
}

@Composable
private fun App() {
    val lifecycle = remember { LifecycleRegistry() }
    val router = remember {
        Router(
            DefaultComponentContext(lifecycle = lifecycle),
            window.location.pathname,
            window.location.search,
        )
    }

    DisposableEffect(true) {
        lifecycle.resume()

        onDispose { lifecycle.destroy() }
    }

    Style(GlobalStyleSheet)

    Routing(router)
}

object GlobalStyleSheet : StyleSheet(MaterialTheme) {
    const val ELEMENT_ID = "root"

    init {
        type("html") style  {
            height(100.percent)
            margin(0.px)
        }
        type("body") style {
            height(100.percent)
            margin(0.px)
            backgroundColor(Color("#121212"))
        }
        type("style") style  {
            margin(0.px)
        }
        type("div") style {
            id(ELEMENT_ID) style {
                height(100.percent)
            }
        }
        type("p") style  {
            type("a") style {
                color(Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)"))
            }
        }
        type("hr") style  {
            height(1.px)
            backgroundColor(Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)"))
            border(0.px)
        }
    }
}
