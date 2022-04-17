@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import components.organisms.titles
import csstype.*
import emotion.react.css
import emotion.styled.styled
import org.w3c.dom.HTMLElement
import react.VFC
import react.create
import react.dom.html.ReactHTML.b
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.hr
import react.dom.html.ReactHTML.img
import react.useRef
import utilities.Links
import utilities.ref
import utilities.useCompose

val WorksCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Works")
    }

    CardFrame {
        div {
            ref { containerRef.current = it }

            SwitchableContents {
                titles("COLOR M@STER", "Kotlin Material-UI", "Otonashi")

                +ColorMaster
                +KotlinMaterialUI
                +Otonashi
            }
        }
    }
}

private val ColorMaster = div.create {
    css { display = Display.flex }

    +ScreenShot("./colormaster_overview.png")
    Introduction {
        Paragraph {
            +"アイドルマスターに登場するキャラクターのイメージカラーに対する、様々な機能を提供するアプリケーションです。"
            +"現在、「検索」「ペンライト」の2つの機能が実装されています。"
        }
        Paragraph {
            +"実装には"
            Links("https://kotlinlang.org/docs/reference/multiplatform.html" to "Kotlin Multiplatform")
            +"を利用しており、"
            Links("https://imas-colormaster.web.app/" to "Webアプリ版")
            +"が既に公開済です。"
        }

        hr {}

        Paragraph {
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

private val KotlinMaterialUI = div.create {
    css { display = Display.flex }

    +ScreenShot("./kotlin_material_ui_overview.png")
    Introduction {
        Paragraph {
            +"React.js向けUIライブラリ「"
            Links("https://material-ui.com/" to "Material-UI")
            +"」のKotlin/JS用ラッパーライブラリです。"
        }

        Paragraph {
            +"Material-UIが提供する100種類以上のUIコンポーネント、およびテーマカスタマイズ用関数を"
            +"Kotlin/JS上で即座に利用することができます。"
        }

        hr {}

        Paragraph {
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

private val Otonashi = div.create {
    css { display = Display.flex }

    +ScreenShot("./otonashi_overview.png")
    Introduction {
        Paragraph {
            +"RDF用クエリ言語「"
            Links("https://www.w3.org/TR/rdf-sparql-query/" to "SPARQL")
            +"」のKotlin製クライアントライブラリです。"
        }

        Paragraph {
            +"SPARQLのトリプルパターンを直感的な文法で記述することができます。"
        }

        Paragraph {
            +"また、"
            Links("https://sparql.crssnky.xyz/imas/" to "im@sparql")
            +"等、特定のSPARQLエンドポイントに対する語彙補完機能も試験的に備えています。"
        }

        hr {}

        Paragraph {
            b { +"GitHub: " }
            Links("https://github.com/subroh0508/otonashi" to "subroh0508/otonashi")
        }
    }
}

private fun ScreenShot(path: String) = div.create {
    css {
        width = 50.pct
        height = 290.px
        margin = Margin(vertical = 16.px, horizontal = 0.px)
    }

    img {
        css {
            width = 90.pct
            maxHeight = 100.pct
            objectFit = ObjectFit.contain
        }

        src = path
    }
}

private val Introduction get() = div.styled { _, _ ->
    width = 50.pct
}
