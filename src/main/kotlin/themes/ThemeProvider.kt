@file:Suppress("FunctionName")

package themes

import kotlinext.js.jsObject
import kotlinx.css.Color
import materialcomponents.ThemeProvider as Provider
import materialcomponents.ThemeProviderProps
import materialcomponents.theme.*
import react.RBuilder



fun RBuilder.ThemeProvider(handler: RBuilder.() -> Unit) = Provider {
    attrs.options {
        surface = Color("#0D386D")
        textPrimaryOnDark = Color("#99B7DC")
        textSecondaryOnDark = Color("#3B91C4")
    }

    console.log(attrs)
    handler()
}

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jsObject(block) }
