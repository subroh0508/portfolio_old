@Suppress("unused")
object Libraries {
    object Plugins {
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
        const val kotlinFrontend = "org.jetbrains.kotlin:kotlin-frontend-plugin:${Versions.kotlinFrontentPlugin}"
    }

    const val kotlinJs = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
    const val kotlinTestJs = "org.jetbrains.kotlin:kotlin-test-js:${Versions.kotlin}"
    const val kotlinxHtml = "org.jetbrains.kotlinx:kotlinx-html-js:${Versions.kotlinxHtml}"
    const val kotlinReact = "org.jetbrains:kotlin-react:${Versions.kotlinReact}"
    const val kotlinReactDom = "org.jetbrains:kotlin-react-dom:${Versions.kotlinReact}"
    const val kotlinJsWrapper = "org.jetbrains:kotlin-styled:${Versions.kotlinJsWrappers}"
    const val kotlinMaterialUi = "subroh0508.net.kotlinmaterialui:core:${Versions.kotlinMaterialUi}"
}
