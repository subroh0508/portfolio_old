import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    kotlin("js")
}

group = Packages.group
version = Packages.version

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
                implementation(Libraries.Kotlin.extensions)
                implementation(Libraries.Kotlin.materialUi)

                implementation(npm("react", Libraries.Npm.react))
                implementation(npm("react-dom", Libraries.Npm.react))
                implementation(npm("styled-components", Libraries.Npm.styledComponent))
                implementation(npm("inline-style-prefixer", Libraries.Npm.inlineStyledPrefixer))
                implementation(npm("react-swipeable-views", Libraries.Npm.reactSwipeableViews))
                implementation(npm("@material-ui/core", Libraries.Npm.materialUi))
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
