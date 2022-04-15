@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.atoms.Subtitle
import components.organisms.CardFrame
import csstype.Display
import csstype.Margin
import csstype.pct
import csstype.px
import emotion.react.css
import react.VFC
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h4
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import utilities.Links

val BiographyCard = VFC {
    CardFrame {
        LargeTitle {
            title = "Biography"
        }

        +AboutMeContent
        div {
            css {
                display = Display.flex
                h4 {
                    margin = Margin(vertical = 8.px, horizontal = 0.px)
                }
            }

            +CareerContent
            +EducationContent
        }
    }
}

private val AboutMeContent = div.create {
    Paragraph {
        +"1995年生まれ。東京の離島・伊豆大島出身のAndroidエンジニア。"
    }

    Paragraph {
        +"東京高専情報工学科を卒業後、2016年4月に株式会社TOKIUMに新卒入社。"
        +"複数のAndroidアプリの新機能開発・保守運用をメインとしつつ、Rails/React ReduxによるWebアプリ開発、およびエンジニア採用の業務にも携わる。"
    }

    Paragraph {
        +"Kotlinとアイドルマスターをこよなく愛する。"
        +"また、アプリケーションの設計にも興味を抱いており、DDDやClean Architectureの思想を効果的に実装へと落とし込むにはどうすべきか、日々試行錯誤を繰り返している。"
    }
}

private val CareerContent = div.create {
    css {
        width = 50.pct
    }

    Subtitle { subtitle = "Career" }

    Paragraph {
        ul {
            li {
                +"2016.04 "
                Links("https://tokium.jp/" to "株式会社TOKIUM")
                +"入社、現職"
            }
        }
    }
}

private val EducationContent = div.create {
    css {
        width = 50.pct
    }

    Subtitle { subtitle = "Education" }

    Paragraph {
        ul {
            li { +"2016.03 東京高専情報工学科卒" }
        }
    }
}
