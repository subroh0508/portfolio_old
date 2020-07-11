import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.targets.js.npm.NpmDependency

plugins {
    kotlin("js") version Libraries.Kotlin.version
}

group = Packages.group
version = Packages.version

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "http://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

kotlin {
    target {
        useCommonJs()
        browser {
            runTask {
                val mainSrc = kotlin.sourceSets["main"]

                sourceMaps = true
                devServer = KotlinWebpackConfig.DevServer(
                    port = 8088,
                    contentBase = mainSrc.resources.srcDirs.map { it.absolutePath }
                )
                outputFileName = "main.bundle.js"
            }
            webpackTask {
                sourceMaps = false
                outputFileName = "main.bundle.js"
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(Libraries.Kotlin.js)
                implementation(Libraries.Kotlin.html)
                implementation(Libraries.Kotlin.react)
                implementation(Libraries.Kotlin.reactDom)
                implementation(Libraries.Kotlin.reactRouterDom)
                implementation(Libraries.Kotlin.extensions)
                implementation(Libraries.Kotlin.styled)

                implementation(npm("react", Libraries.Npm.react))
                implementation(npm("react-dom", Libraries.Npm.react))
                implementation(npm("react-router-dom", Libraries.Npm.reactRouterDom))
                implementation(npm("styled-components", Libraries.Npm.styledComponent))
                implementation(npm("inline-style-prefixer", Libraries.Npm.inlineStyledPrefixer))
                implementation(npm("react-swipeable-views", Libraries.Npm.reactSwipeableViews))
                implementation(npm("@rmwc/avatar", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/card", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/drawer", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/icon", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/list", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/ripple", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/typography", Libraries.Npm.materialWebComponents))
                implementation(npm("@rmwc/theme", Libraries.Npm.materialWebComponents))

                implementation(devNpm("style-loader"))
                implementation(devNpm("css-loader"))
            }
        }
    }
}

val browserWebpack = tasks.getByName("browserProductionWebpack")

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

browserWebpack.finalizedBy(copyDistributions)

fun devNpm(name: String, version: String = "*") = NpmDependency(project, name, version, NpmDependency.Scope.DEV)
