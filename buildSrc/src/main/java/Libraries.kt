@Suppress("unused")
object Libraries {
    object Plugins {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object Kotlin {
        const val version = "1.3.72"
        const val wrappersBuild = "pre.110-kotlin-$version"

        const val js = "org.jetbrains.kotlin:kotlin-stdlib-js:$version"

        const val reactVersion = "${Npm.react}-$wrappersBuild"
        const val react = "org.jetbrains:kotlin-react:$reactVersion"
        const val reactDom = "org.jetbrains:kotlin-react-dom:$reactVersion"

        const val reactRouterDomVersion = "${Npm.reactRouterDom}-$wrappersBuild"
        const val reactRouterDom = "org.jetbrains:kotlin-react-router-dom:$reactRouterDomVersion"

        const val htmlVersion = "0.6.12"
        const val html = "org.jetbrains.kotlinx:kotlinx-html-js:$htmlVersion"

        const val cssVersion = "1.0.0-$wrappersBuild"
        const val css = "org.jetbrains:kotlin-css-js:$cssVersion"

        const val styledVersion = "1.0.0-$wrappersBuild"
        const val styled = "org.jetbrains:kotlin-styled:$styledVersion"

        const val extensionsVersion = "1.0.1-$wrappersBuild"
        const val extensions = "org.jetbrains:kotlin-extensions:$extensionsVersion"
    }

    object Npm {
        const val react = "16.13.1"
        const val reactRouterDom = "5.1.2"
        const val styledComponent = "^4.4.1"
        const val inlineStyledPrefixer = "^5.1.2"
        const val reactSwipeableViews = "^0.13.9"
        const val materialWebComponents = "^6.0.14"
    }
}
