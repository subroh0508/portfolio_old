@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import components.atoms.*
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import routes.Page
import routes.Router
import utilities.getIndex

private val WORKS_TITLES = listOf("COLOR M@STER", "Kotlin Material-UI", "Otonashi")

@Composable
fun WorksCard(router: Router, index: Int) = CardFrame {
    val currentIndex by getIndex(index, WORKS_TITLES.size)  {
        router.toWorks(0)
    }

    LargeTitle(text = "Works")

    SwitchableContents(
        WORKS_TITLES,
        router.getLastIndex() to currentIndex,
        click = router::toWorks,
        { ColorMaster() },
        { KotlinMaterialUI() },
        { Otonashi() },
    )
}

@Composable
private fun ColorMaster() = Div({
    style {
        display(DisplayStyle.Flex)
    }
}) {
    ScreenShot("./colormaster_overview.png")
    Introduction {
        Paragraph {
            Text("アイドルマスターに登場するキャラクターのイメージカラーに対する、様々な機能を提供するアプリケーションです。")
            Text("現在、「検索」「ペンライト」の2つの機能が実装されています。")
        }
        Paragraph {
            Text("実装には")
            Link("https://kotlinlang.org/docs/reference/multiplatform.html" to "Kotlin Multiplatform")
            Text("を利用しており、")
            Link("https://imas-colormaster.web.app/" to "Webアプリ版")
            Text("が既に公開済です。")
        }
        Hr {}
        Paragraph {
            B { Text("使用ライブラリ: ") }
            Links(
                "https://react.i18next.com/" to "react-i18next",
                "https://github.com/subroh0508/kotlin-material-ui" to "kotlin-material-ui",
            )
            Br {}
            Links(
                "https://ktor.io/" to "Ktor",
                "https://github.com/Kotlin/kotlinx.serialization" to "kotlinx.serialization",
                "https://kodein.org/Kodein-DI/" to "Kodein-DI"
            )
            Br {}
            B { Text("GitHub: ") }
            Links("https://github.com/subroh0508/colormaster" to "subroh0508/colormaster")
        }
    }
}

@Composable
private fun KotlinMaterialUI() = Div({
    style {
        display(DisplayStyle.Flex)
    }
}) {
    ScreenShot("./kotlin_material_ui_overview.png")
    Introduction {
        Paragraph {
            Text("React.js向けUIライブラリ「")
            Links("https://material-ui.com/" to "Material-UI")
            Text("」のKotlin/JS用ラッパーライブラリです。")
        }

        Paragraph {
            Text("Material-UIが提供する100種類以上のUIコンポーネント、およびテーマカスタマイズ用関数を")
            Text("Kotlin/JS上で即座に利用することができます。")
        }

        Hr {}

        Paragraph {
            B { Text("使用ライブラリ: ") }
            Links(
                "https://material-ui.com/" to "Material-UI",
                "https://github.com/JetBrains/kotlin-wrappers" to "kotlin-wrappers"
            )
            Br {}
            B { Text("GitHub: ") }
            Links("https://github.com/subroh0508/kotlin-material-ui" to "subroh0508/kotlin-material-ui")
        }
    }
}

@Composable
private fun Otonashi() = Div({
    style {
        display(DisplayStyle.Flex)
    }
}) {
    ScreenShot("./otonashi_overview.png")
    Introduction {
        Paragraph {
            Text("RDF用クエリ言語「")
            Links("https://www.w3.org/TR/rdf-sparql-query/" to "SPARQL")
            Text("」のKotlin製クライアントライブラリです。")
        }

        Paragraph {
            Text("SPARQLのトリプルパターンを直感的な文法で記述することができます。")
        }

        Paragraph {
            Text("また、")
            Links("https://sparql.crssnky.xyz/imas/" to "im@sparql")
            Text("等、特定のSPARQLエンドポイントに対する語彙補完機能も試験的に備えています。")
        }

        Hr {}

        Paragraph {
            B { Text("GitHub: ") }
            Links("https://github.com/subroh0508/otonashi" to "subroh0508/otonashi")
        }
    }
}
@Composable
private fun ScreenShot(path: String) = Div({
    style {
        width(50.percent)
        height(290.px)
        margin(16.px, 0.px)
    }
}) {
    Img(path, attrs = {
        style {
            width(90.percent)
            maxHeight(100.percent)
            property("object-fit", "contain")
        }
    })
}

@Composable
private fun Introduction(content: @Composable () -> Unit) = Div({
    style { width(50.percent) }
}) { content() }

private fun Router.getLastIndex() = routerState.value.backStack.lastOrNull()?.configuration?.let {
    if (it is Page.Works) it.index else null
} ?: -1
