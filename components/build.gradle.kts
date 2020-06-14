import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import org.jetbrains.kotlin.gradle.targets.js.npm.NpmDependency

plugins {
    kotlin("js")
}

dependencies {
    implementation(Libraries.Kotlin.js)
    implementation(Libraries.Kotlin.html)
    implementation(Libraries.Kotlin.react)
    implementation(Libraries.Kotlin.reactDom)
    implementation(Libraries.Kotlin.extensions)

    implementation(npm("react", Libraries.Npm.react))
    implementation(npm("react-dom", Libraries.Npm.react))
    implementation(npm("styled-components", Libraries.Npm.styledComponent))
    implementation(npm("inline-style-prefixer", Libraries.Npm.inlineStyledPrefixer))

    implementation(devNpm("@storybook/react", Libraries.Npm.storybook))
    implementation(devNpm("@babel/core", Libraries.Npm.babel))
    implementation(devNpm("babel-loader", Libraries.Npm.babelLoader))
}

fun devNpm(name: String, version: String = "*") = NpmDependency(project, name, version, NpmDependency.Scope.DEV)
