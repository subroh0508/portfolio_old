@file:Suppress("FunctionName")

package themes

import kotlinext.js.jsObject
import kotlinx.css.Color
import kotlinx.css.height
import kotlinx.css.pct
import materialcomponents.ThemeProvider as Provider
import materialcomponents.ThemeProviderProps
import materialcomponents.theme.*
import react.RBuilder
import styled.StyledHandler
import styled.css
import styled.styled

fun RBuilder.ThemeProvider(handler: RBuilder.() -> Unit) = StyledThemeProvider {
    attrs.options {
        surface = Color("#0D386D")
        textPrimaryOnDark = Color("#99B7DC")
        textSecondaryOnDark = Color("#3B91C4")
    }

    handler()
}

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jsObject(block) }

private fun RBuilder.StyledThemeProvider(handler: StyledHandler<ThemeProviderProps>) = (styled(Provider)) {
    css {
        height = 100.pct
    }

    handler()
}
