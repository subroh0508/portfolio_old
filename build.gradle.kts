
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
    kotlin("js")
    id("kotlin-dce-js")
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

val runDceKotlin by tasks.getting(KotlinJsDce::class)

kotlin {
    target {
        useCommonJs()
        browser {
            runTask {
                sourceMaps = true
                devServer = KotlinWebpackConfig.DevServer(
                    port = 8088,
                    contentBase = listOf("${runDceKotlin.destinationDir}/resources")
                )
                archiveFileName = "main.bundle.js"
            }
            webpackTask {
                sourceMaps = false
                archiveFileName = "main.bundle.js"
            }
        }
    }

    sourceSets {
        val main by getting {
            dependencies {
                implementation(Libraries.kotlinJs)
                implementation(Libraries.kotlinxHtml)
                implementation(Libraries.kotlinReact)
                implementation(Libraries.kotlinReactDom)
                implementation(Libraries.kotlinJsWrapper)
                implementation(Libraries.kotlinMaterialUi)

                implementation(npm("react", Versions.Npm.react))
                implementation(npm("react-dom", Versions.Npm.react))
                implementation(npm("styled-components", Versions.Npm.styledComponent))
                implementation(npm("inline-style-prefixer", Versions.Npm.inlineStyledPrefixer))
                implementation(npm("react-swipeable-views"))
                implementation(npm("@material-ui/core", Versions.Npm.materialUi))
            }
        }

        val test by getting {
            dependencies {
                implementation(Libraries.kotlinTestJs)
            }
        }
    }
}

val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["main"]

    from(mainSrc.resources.srcDirs)
    into("${runDceKotlin.destinationDir}/resources")
}

afterEvaluate {
    tasks["browserWebpack"].dependsOn(copyResources, runDceKotlin)
    tasks["browserRun"].dependsOn(copyResources)
}
