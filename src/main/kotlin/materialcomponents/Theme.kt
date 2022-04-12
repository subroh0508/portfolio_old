@file:JsModule("@rmwc/theme")
@file:JsNonModule

package materialcomponents

import materialcomponents.theme.ThemeProviderOption
import react.ElementType
import react.PropsWithChildren
import react.PropsWithClassName

external interface ThemeProviderProps : PropsWithChildren, PropsWithClassName {
    var options: ThemeProviderOption?
}

external val ThemeProvider : ElementType<ThemeProviderProps>
