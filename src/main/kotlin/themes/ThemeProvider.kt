@file:Suppress("FunctionName")

package themes

import csstype.Color
import csstype.pct
import emotion.styled.styled
import kotlinx.js.jso
import materialcomponents.ThemeProvider as Provider
import materialcomponents.ThemeProviderProps
import materialcomponents.theme.*
import react.FC

val ThemeProvider = FC<ThemeProviderProps> { props ->
    StyledProvider {
        options {
            background = Color("#121212")
            surface = Color("#0D386D")
            primary = Color("#0D386D")
            textPrimaryOnDark = Color("#99B7DC")
            textSecondaryOnDark = Color("#3B91C4")
        }

        +props.children
    }
}

fun ThemeProviderProps.options(block: ThemeProviderOption.() -> Unit) { options = jso(block) }

private val StyledProvider = Provider.styled { _, _ ->
    height = 100.pct
}
