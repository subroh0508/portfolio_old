@file:JsModule("@rmwc/theme")

package materialcomponents

import materialcomponents.theme.ThemeProviderOption
import react.RProps

external interface ThemeProviderProps : RProps {
    var options: ThemeProviderOption?
}
