@Suppress("unused")
object Libraries {
    object Plugins {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Kotlin.version}"
    }

    object Kotlin {
        internal const val version = "1.6.20"
        private const val wrappersVersion = "pre.328-kotlin-$version"
        private const val wrappersBomVersion = "0.0.1-$wrappersVersion"
        const val wrappersBom = "org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:$wrappersBomVersion"

        const val react = "org.jetbrains.kotlin-wrappers:kotlin-react"
        const val reactDom = "org.jetbrains.kotlin-wrappers:kotlin-react-dom"
        const val history = "org.jetbrains.kotlin-wrappers:kotlin-history"
        const val reactRouterDom = "org.jetbrains.kotlin-wrappers:kotlin-react-router-dom"
        const val emotion = "org.jetbrains.kotlin-wrappers:kotlin-emotion"
        const val extensions = "org.jetbrains.kotlin-wrappers:kotlin-extensions"
    }

    object Npm {
        const val materialWebComponents = "^7.0.3"
    }
}
