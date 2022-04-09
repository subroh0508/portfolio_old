@file:JsModule("@rmwc/theme")
@file:JsNonModule

package materialcomponents

import materialcomponents.theme.ThemeProviderOption
import react.ElementType
import react.PropsWithClassName

external interface ThemeProviderProps : PropsWithClassName {
    var options: ThemeProviderOption?
}

external val ThemeProvider : ElementType<ThemeProviderProps>
