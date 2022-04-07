@file:Suppress("FunctionName")

package themes

import kotlinx.css.Color
import kotlinx.css.height
import kotlinx.css.pct
import kotlinx.js.jso
import materialcomponents.ThemeProvider as Provider
import materialcomponents.ThemeProviderProps
import materialcomponents.theme.*
import react.RBuilder
import styled.StyledHandler
import styled.css
import styled.styled

fun RBuilder.ThemeProvider(handler: RBuilder.() -> Unit) = StyledThemeProvider {
    attrs.options {
        background = Color("#121212")
        surface = Color("#0D386D")
        primary = Color("#0D386D")
        textPrimaryOnDark = Color("#99B7DC")
        textSecondaryOnDark = Color("#3B91C4")
    }

    handler()
}

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jso(block) }

private fun RBuilder.StyledThemeProvider(handler: StyledHandler<ThemeProviderProps>) = (styled(Provider)) {
    css {
        height = 100.pct
    }

    handler()
}
