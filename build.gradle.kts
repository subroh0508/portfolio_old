plugins {
    kotlin("js")
    `node-conventions`
}

group = Packages.group
version = Packages.version

repositories {
    mavenCentral()
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
}

dependencies {
    implementation(enforcedPlatform(Libraries.Kotlin.wrappersBom))
    implementation(Libraries.Kotlin.react)
    implementation(Libraries.Kotlin.reactDom)
    implementation(Libraries.Kotlin.reactRouterDom)
    implementation(Libraries.Kotlin.history)
    implementation(Libraries.Kotlin.extensions)
    implementation(Libraries.Kotlin.emotion)

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
