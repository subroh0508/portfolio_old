@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Link
import components.atoms.Paragraph
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import components.organisms.titles
import kotlinx.css.*
import react.RBuilder
import react.child
import react.dom.*
import react.functionalComponent
import styled.css
import styled.styledDiv
import styled.styledImg

val WorksCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(LargeTitle) {
            attrs.title = "Works"
        }

        child(SwitchableContents) {
            attrs.titles("COLOR M@STER", "Kotlin Material-UI", "Otonashi")

            ColorMaster()
            KotlinMaterialUI()
            Otonashi()
        }
    }
}

private fun RBuilder.ColorMaster() = styledDiv {
    css { display = Display.flex }

    ScreenShot("./colormaster_overview.png")
    Introduction {
        child(Paragraph) {
            +"アイドルマスターに登場するキャラクターのイメージカラーに対する、様々な機能を提供するアプリケーションです。"
            +"現在、「検索」「ペンライト」の2つの機能が実装されています。"
        }
        child(Paragraph) {
            +"実装には"
            Links("https://kotlinlang.org/docs/reference/multiplatform.html" to "Kotlin Multiplatform")
            +"を利用しており、"
            Links("https://imas-colormaster.web.app/" to "Webアプリ版")
            +"が既に公開済です。"
        }

        hr {}

        child(Paragraph) {
            b { +"使用ライブラリ: " }
            Links(
                    "https://react.i18next.com/" to "react-i18next",
                    "https://github.com/subroh0508/kotlin-material-ui" to "kotlin-material-ui"
            )
            br {}
            Links(
                    "https://ktor.io/" to "Ktor",
                    "https://github.com/Kotlin/kotlinx.serialization" to "kotlinx.serialization",
                    "https://kodein.org/Kodein-DI/" to "Kodein-DI"
            )
            br {}
            b { +"GitHub: " }
            Links("https://github.com/subroh0508/colormaster" to "subroh0508/colormaster")
        }
    }
}

private fun RBuilder.KotlinMaterialUI() = styledDiv {
    css { display = Display.flex }

    ScreenShot("./kotlin_material_ui_overview.png")
    Introduction {
        child(Paragraph) {
            +"React.js向けUIライブラリ「"
            Links("https://material-ui.com/" to "Material-UI")
            +"」のKotlin/JS用ラッパーライブラリです。"
        }

        child(Paragraph) {
            +"Material-UIが提供する100種類以上のUIコンポーネント、およびテーマカスタマイズ用関数を"
            +"Kotlin/JS上で即座に利用することができます。"
        }

        hr {}

        child(Paragraph) {
            b { +"使用ライブラリ: " }
            Links(
                    "https://material-ui.com/" to "Material-UI",
                    "https://github.com/JetBrains/kotlin-wrappers" to "kotlin-wrappers"
            )
            br {}
            b { +"GitHub: " }
            Links("https://github.com/subroh0508/kotlin-material-ui" to "subroh0508/kotlin-material-ui")
        }
    }
}

private fun RBuilder.Otonashi() = styledDiv {
    css { display = Display.flex }

    ScreenShot("./otonashi_overview.png")
    Introduction {
        child(Paragraph) {
            +"RDF用クエリ言語「"
            Links("https://www.w3.org/TR/rdf-sparql-query/" to "SPARQL")
            +"」のKotlinクライアントライブラリです。"
        }

        child(Paragraph) {
            +"SPARQLのトリプルパターンを直感的な文法で記述することができます。"
        }

        child(Paragraph) {
            +"また、"
            Links("https://sparql.crssnky.xyz/imas/" to "im@sparql")
            +"等、特定のSPARQLエンドポイントに対する語彙補完機能も試験的に備えています。"
        }

        hr {}

        child(Paragraph) {
            b { +"GitHub: " }
            Links("https://github.com/subroh0508/otonashi" to "subroh0508/otonashi")
        }
    }
}

private fun RBuilder.ScreenShot(src: String) = styledDiv {
    css {
        width = 50.pct
        height = 290.px
        margin(vertical = 16.px)
    }

    styledImg {
        css {
            width = 90.pct
            maxHeight = 100.pct
            objectFit = ObjectFit.contain
        }

        attrs.src = src
    }
}

private fun RBuilder.Introduction(block: RBuilder.() -> Unit) = styledDiv {
    css { width = 50.pct }

    block()
}

private fun RBuilder.Links(vararg links: Pair<String, String>) = links.forEachIndexed { i, (href, text) ->
    a {
        attrs.href = href
        attrs.target = "_blank"
        +text
    }
    if (i != links.size - 1) +"/"
}
