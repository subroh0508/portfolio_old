@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.*
import components.organisms.CardFrame
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.w3c.dom.HTMLElement
import react.VFC
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

val BiographyCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        Style(BiographyCardStyle)

        LargeTitle(text = "Biography")

        AboutMeContent()

        Div({ classes(BiographyCardStyle.content) }) {
            CareerContent()
            EducationContent()
        }
    }

    CardFrame {
        div {
            ref { containerRef.current = it }
        }
    }
}

@Composable
private fun AboutMeContent() {
    Div {
        ComposableParagraph {
            Text("1995年生まれ。東京の離島・伊豆大島出身のAndroidエンジニア。")
        }
        ComposableParagraph {
            Text("東京高専情報工学科を卒業後、2016年4月に株式会社TOKIUMに新卒入社。")
            Text("複数のAndroidアプリの新機能開発・保守運用をメインとしつつ、Rails/React ReduxによるWebアプリ開発、およびエンジニア採用の業務にも携わる。")
        }
        ComposableParagraph {
            Text("Kotlinとアイドルマスターをこよなく愛する。")
            Text("また、アプリケーションの設計にも興味を抱いており、DDDやClean Architectureの思想を効果的に実装へと落とし込むにはどうすべきか、日々試行錯誤を繰り返している。")
        }
    }
}

@Composable
private fun CareerContent() {
    Div({
        style {
            width(50.percent)
        }
    }) {
        Subtitle(text = "Career")

        ComposableParagraph {
            Ul {
                Li {
                    Text("2016.04 ")
                    Link("https://tokium.jp/" to "株式会社TOKIUM")
                    Text("入社、現職")
                }
            }
        }
    }
}

@Composable
private fun EducationContent() {
    Div({
        style {
            width(50.percent)
        }
    }) {
        Subtitle(text = "Education")

        ComposableParagraph {
            Ul {
                Li {
                    Text("2016.03 東京高専情報工学科卒")
                }
            }
        }
    }
}
private object BiographyCardStyle : StyleSheet() {
    val content by style {
        display(DisplayStyle.Flex)

        type("h4") style  {
            margin(8.px, 0.px)
        }
    }
}
