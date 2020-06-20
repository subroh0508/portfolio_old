package materialcomponents

import kotlinext.js.jsObject
import materialcomponents.theme.ThemeProviderOption

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jsObject(block) }
