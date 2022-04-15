import org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose")
    `node-conventions`
}

group = Packages.group
version = Packages.version

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

kotlin {
    js(IR) {
        binaries.executable()

        browser {
            commonWebpackConfig {
                outputFileName = "main.bundle.js"
            }
            runTask {
                cssSupport.enabled = false
                sourceMaps = true
            }
            webpackTask {
                cssSupport.enabled = true
                sourceMaps = false
            }
        }
    }

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation(enforcedPlatform(Libraries.Kotlin.wrappersBom))
                implementation(Libraries.Kotlin.react)
                implementation(Libraries.Kotlin.reactDom)
                implementation(Libraries.Kotlin.reactRouterDom)
                implementation(Libraries.Kotlin.history)
                implementation(Libraries.Kotlin.extensions)
                implementation(Libraries.Kotlin.emotion)
                implementation(compose.web.core)
                implementation(compose.runtime)
                implementation(Libraries.decompose)

                implementation(npm("@rmwc/avatar", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/card", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/drawer", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/icon", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/list", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/ripple", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/typography", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/theme", Libraries.Npm.materialWebComponents))

                implementation(devNpm("style-loader", "*"))
                implementation(devNpm("html-webpack-plugin", "^5.5.0"))
                implementation(devNpm("webpack-cdn-plugin", "^3.3.1"))
            }
        }
        named("jsTest") {

        }
    }
}

fun KotlinDependencyHandler.enforcedPlatform(dependencyNotation: Any) = project.dependencies.enforcedPlatform(dependencyNotation)

val jsBrowserWebpack = tasks.getByName("jsBrowserProductionWebpack")

val copyDistributions by tasks.registering {
    doLast {
        copy {
            val destinationDir = File("$rootDir/public")
            if (!destinationDir.exists()) {
                destinationDir.mkdir()
            }
            val distributions = File("$buildDir/distributions/")
            from(distributions)
            into(destinationDir)
        }
    }
}

jsBrowserWebpack.finalizedBy(copyDistributions)
