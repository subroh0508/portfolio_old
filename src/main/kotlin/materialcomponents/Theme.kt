@file:JsModule("@rmwc/theme")

package materialcomponents

import materialcomponents.theme.ThemeProviderOption
import react.RClass
import react.RProps
import react.dom.WithClassName

external interface ThemeProviderProps : WithClassName {
    var options: ThemeProviderOption?
}

external val ThemeProvider : RClass<ThemeProviderProps>
