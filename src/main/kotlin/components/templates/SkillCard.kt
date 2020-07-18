@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.atoms.Subtitle
import components.organisms.CardFrame
import kotlinx.css.*
import react.RBuilder
import react.child
import react.dom.WithClassName
import react.dom.li
import react.dom.ul
import react.functionalComponent
import styled.css
import styled.styledDiv

val SkillCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(LargeTitle) {
            attrs.title = "Skill"
        }

        styledDiv {
            css {
                display = Display.flex

                h4 { margin(vertical = 8.px) }

            }

            Kotlin()
            RubyOnRails()
        }
    }
}

private fun RBuilder.Kotlin() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "Kotlin" }

    child(Paragraph) {
        ul {
            li { +"経験年数: 2016.02-" }
            li { +"v1.0が出る直前に業務で触れて以来、Androidアプリの開発で使い続けています。" }
            li { +"プライベートでは、Kotlin/JSを使ったWebアプリの開発や、OSS活動にも積極的に関わっています。" }
        }
    }
}

private fun RBuilder.RubyOnRails() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "Ruby on Rails" }

    child(Paragraph) {
        ul {
            li { +"経験年数: 2016.06-" }
            li { +"大規模な機能追加・新規サービスの立ち上げ・DDD + Clean Architectureに沿ったリファクタの経験があります。" }
        }
    }
}
