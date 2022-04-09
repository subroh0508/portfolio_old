@file:Suppress("FunctionName")

package themes

import csstype.pct
import emotion.styled.styled
import kotlinx.css.Color
import kotlinx.js.jso
import materialcomponents.ThemeProvider as Provider
import materialcomponents.ThemeProviderProps
import materialcomponents.theme.*
import react.ChildrenBuilder

fun ChildrenBuilder.ThemeProvider(block: ChildrenBuilder.() -> Unit) = StyledProvider {
    options {
        background = Color("#121212")
        surface = Color("#0D386D")
        primary = Color("#0D386D")
        textPrimaryOnDark = Color("#99B7DC")
        textSecondaryOnDark = Color("#3B91C4")
    }

    block()
}

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jso(block) }

private val StyledProvider = Provider.styled { _, _ ->
    height = 100.pct
}
