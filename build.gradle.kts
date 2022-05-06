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
                implementation(compose.web.core)
                implementation(compose.web.svg)
                implementation(compose.runtime)
                implementation(Libraries.decompose)

                implementation(npm("@material/button", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/card", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/drawer", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/list", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/ripple", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/theme", Libraries.Npm.materialComponentsWeb))
                implementation(npm("@material/typography", Libraries.Npm.materialComponentsWeb))

                implementation(devNpm("sass", "^1.51.0"))
                implementation(devNpm("sass-loader", "^12.6.0"))
                implementation(devNpm("extract-loader", "^5.1.0"))
                implementation(devNpm("file-loader", "^6.2.0"))
                implementation(devNpm("autoprefixer", "^10.4.7"))
                implementation(devNpm("postcss-loader", "^6.2.1"))
            }
        }
        named("jsTest") {

        }
    }
}

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
