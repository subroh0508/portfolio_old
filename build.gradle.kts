
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackBundleTask
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackRunTask
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile
import org.jetbrains.kotlin.gradle.tasks.KotlinJsDce

plugins {
    id("kotlin2js")
    id("kotlin-dce-js")
    id("org.jetbrains.kotlin.frontend")
}

group = "net.subroh0508"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
    maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    maven(url = "http://dl.bintray.com/kotlinx/kotlinx")
    maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
}

dependencies {
    implementation(Dep.kotlinJs)
    implementation(Dep.kotlinxHtml)
}

kotlinFrontend {
    sourceMaps = true

    npm {
        dependency("core-js", "3.0.0")
        dependency("react")
        dependency("react-dom")
        dependency("react-router")
        dependency("react-markdown")
        dependency("styled-components", "3.4.10")
        dependency("inline-style-prefixer")

        devDependency("css-loader")
        devDependency("style-loader")
        devDependency("babel-loader")
        devDependency("babel-core")
        devDependency("karma")
    }

    bundle<WebPackExtension>("webpack") {
        (this as WebPackExtension).apply {
            bundleName = "main"
            contentPath = file("src/main/resources")
            mode = "production"
        }
    }
}

val compileKotlin2Js by tasks.getting(Kotlin2JsCompile::class) {
    kotlinOptions {
        metaInfo = true
        outputFile = "${project.buildDir.path}/js/${project.name}.js"
        sourceMap = true
        sourceMapEmbedSources = "always"
        moduleKind = "commonjs"
        main = "call"
    }
}

val compileTestKotlin2Js by tasks.getting(Kotlin2JsCompile::class) {
    kotlinOptions {
        metaInfo = true
        outputFile = "${project.buildDir.path}/js-tests/${project.name}-tests.js"
        sourceMap = true
        moduleKind = "commonjs"
        main = "call"
    }
}

/*
val copyResources by tasks.registering(Copy::class) {
    val mainSrc = kotlin.sourceSets["main"]
    from(mainSrc.resources.srcDirs)
    into(file(project.buildDir.path + "/js/min"))
}
*/

val runDceKotlinJs by tasks.getting(KotlinJsDce::class)

afterEvaluate {
    tasks.getting(WebPackBundleTask::class) { dependsOn(runDceKotlinJs) }
    tasks.getting(WebPackRunTask::class) { dependsOn(runDceKotlinJs)  }
}
