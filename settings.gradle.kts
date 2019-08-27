pluginManagement {
    repositories {
        gradlePluginPortal()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "kotlin-dce-js" -> useModule(Libraries.Plugins.kotlinGradle)
                "org.jetbrains.kotlin.js" -> useModule(Libraries.Plugins.kotlinFrontend)
            }
        }
    }
}
rootProject.name = "portfolio"
