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

        const val historyVersion = "${Npm.history}-$wrappersBuild"
        const val history = "org.jetbrains.kotlin-wrappers:kotlin-history:$historyVersion"

        const val reactRouterDomVersion = "${Npm.reactRouterDom}-$wrappersBuild"
        const val reactRouterDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:$reactRouterDomVersion"

        const val emotionVersion = "${Npm.emotion}-$wrappersBuild"
        const val emotion = "org.jetbrains.kotlin-wrappers:kotlin-emotion:$emotionVersion"

        const val extensionsVersion = "1.0.1-$wrappersBuild"
        const val extensions = "org.jetbrains.kotlin-wrappers:kotlin-extensions:$extensionsVersion"
    }

    object Npm {
        const val react = "18.0.0"
        const val history = "5.3.0"
        const val reactRouterDom = "6.3.0"
        const val emotion = "11.8.2"
        const val materialWebComponents = "^7.0.3"
    }
}
