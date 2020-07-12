@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.atoms.Subtitle
import components.organisms.CardFrame
import kotlinx.css.*
import kotlinx.css.h4 as cssH4
import react.RBuilder
import react.child
import react.dom.*
import react.functionalComponent
import styled.css
import styled.styledDiv

val BiographyCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(LargeTitle) {
            attrs.title = "Biography"
        }

        AboutMeContent()
        styledDiv {
            css {
                display = Display.flex

                cssH4 { margin(vertical = 8.px) }
            }

            CareerContent()
            EducationContent()
        }
    }
}

private fun RBuilder.AboutMeContent() = div {
    child(Paragraph) {
        +"1995年生まれ。東京の離島・伊豆大島出身のAndroidエンジニア。"
    }

    child(Paragraph) {
        +"東京高専情報工学科を卒業後、2016年4月に株式会社BearTailに新卒入社。"
        +"複数のAndroidアプリの新機能開発・保守運用をメインとしつつ、Rails/React ReduxによるWebアプリ開発、およびエンジニア採用の業務にも携わる。"
    }

    child(Paragraph) {
        +"Kotlinとアイドルマスターをこよなく愛する。"
        +"また、アプリケーションの設計にも興味を抱いており、DDDやClean Architectureの思想を効果的に実装へと落とし込むにはどうすべきか、日々試行錯誤を繰り返している。"
    }
}

private fun RBuilder.CareerContent() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "Career" }

    child(Paragraph) {
        ul {
            li { +"2016.04 株式会社BearTail入社、現職" }
        }
    }
}

private fun RBuilder.EducationContent() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "Education" }

    child(Paragraph) {
        ul {
            li { +"2016.03 東京高専情報工学科卒" }
        }
    }
}

