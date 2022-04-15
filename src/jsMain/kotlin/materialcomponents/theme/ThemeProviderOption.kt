package materialcomponents.theme

import csstype.Color
import materialcomponents.delegates.OptionsProperty

external interface ThemeProviderOption

var ThemeProviderOption.primary: Color? by OptionsProperty()
var ThemeProviderOption.secondary: Color? by OptionsProperty()
var ThemeProviderOption.background: Color? by OptionsProperty()
var ThemeProviderOption.surface: Color? by OptionsProperty()
var ThemeProviderOption.error: Color? by OptionsProperty()
var ThemeProviderOption.onPrimary: Color? by OptionsProperty()
var ThemeProviderOption.onSecondary: Color? by OptionsProperty()
var ThemeProviderOption.onSurface: Color? by OptionsProperty()
var ThemeProviderOption.onError: Color? by OptionsProperty()
var ThemeProviderOption.textPrimaryOnBackground: Color? by OptionsProperty()
var ThemeProviderOption.textSecondaryOnBackground: Color? by OptionsProperty()
var ThemeProviderOption.textHintOnBackground: Color? by OptionsProperty()
var ThemeProviderOption.textDisabledOnBackground: Color? by OptionsProperty()
var ThemeProviderOption.textIconOnBackground: Color? by OptionsProperty()
var ThemeProviderOption.textPrimaryOnLight: Color? by OptionsProperty()
var ThemeProviderOption.textSecondaryOnLight: Color? by OptionsProperty()
var ThemeProviderOption.textHintOnLight: Color? by OptionsProperty()
var ThemeProviderOption.textDisabledOnLight: Color? by OptionsProperty()
var ThemeProviderOption.textIconOnLight: Color? by OptionsProperty()
var ThemeProviderOption.textPrimaryOnDark: Color? by OptionsProperty()
var ThemeProviderOption.textSecondaryOnDark: Color? by OptionsProperty()
var ThemeProviderOption.textHintOnDark: Color? by OptionsProperty()
var ThemeProviderOption.textDisabledOnDark: Color? by OptionsProperty()
var ThemeProviderOption.textIconOnDark: Color? by OptionsProperty()
