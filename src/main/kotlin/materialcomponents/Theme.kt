@file:JsModule("@rmwc/theme")

package materialcomponents

import materialcomponents.theme.ThemeProviderOption
import react.ElementType
import styled.StyledProps

external interface ThemeProviderProps : StyledProps {
    var options: ThemeProviderOption?
}

external val ThemeProvider : ElementType<ThemeProviderProps>
