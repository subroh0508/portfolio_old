@Suppress("unused")
object Libraries {
    object Plugins {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object Kotlin {
        const val version = "1.6.20"
        const val wrappersBuild = "pre.328-kotlin-$version"

        const val js = "org.jetbrains.kotlin:kotlin-stdlib-js:$version"

        const val reactVersion = "${Npm.react}-$wrappersBuild"
        const val react = "org.jetbrains.kotlin-wrappers:kotlin-react:$reactVersion"
        const val reactDom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom:$reactVersion"
        const val reactLegacy = "org.jetbrains.kotlin-wrappers:kotlin-react-legacy:$reactVersion"
        const val reactDomLegacy = "org.jetbrains.kotlin-wrappers:kotlin-react-dom-legacy:$reactVersion"

        const val historyVersion = "${Npm.history}-$wrappersBuild"
        const val history = "org.jetbrains.kotlin-wrappers:kotlin-history:$historyVersion"

        const val reactRouterDomVersion = "${Npm.reactRouterDom}-$wrappersBuild"
        const val reactRouterDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$reactRouterDomVersion"

        const val htmlVersion = "0.7.2"
        const val html = "org.jetbrains.kotlinx:kotlinx-html-js:$htmlVersion"

        const val cssVersion = "1.0.0-$wrappersBuild"
        const val css = "org.jetbrains.kotlin-wrappers:kotlin-css-js:$cssVersion"

        const val styledVersion = "${Npm.styledComponent}-$wrappersBuild"
        const val styled = "org.jetbrains.kotlin-wrappers:kotlin-styled:$styledVersion"

        const val emotionVersion = "${Npm.emotion}-$wrappersBuild"
        const val emotion = "org.jetbrains.kotlin-wrappers:kotlin-emotion:$emotionVersion"

        const val extensionsVersion = "1.0.1-$wrappersBuild"
        const val extensions = "org.jetbrains.kotlin-wrappers:kotlin-extensions:$extensionsVersion"
    }

    object Npm {
        const val react = "18.0.0"
        const val history = "5.3.0"
        const val reactRouterDom = "6.3.0"
        const val styledComponent = "5.3.5"
        const val emotion = "11.8.2"
        const val materialWebComponents = "^7.0.3"
    }
}
