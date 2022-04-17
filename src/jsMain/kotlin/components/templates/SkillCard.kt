@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.organisms.CardFrame
import components.organisms.SkillRow
import components.organisms.SkillTable
import org.w3c.dom.HTMLElement
import react.VFC
import react.create
import react.createElement
import react.useRef
import utilities.ref
import utilities.useCompose

val SkillCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Skill")
    }

    CardFrame {
        ref { containerRef.current = it }

        +MainSkills
        +OtherSkills
    }
}

private val MainSkills = VFC {
    SkillTable {
        SkillRow {
            name = "Kotlin"
            stars = 5
            since = "2016.02"

            +"v1.0が出る直前に業務で触れて以来、Androidアプリの開発で使い続けています。"
            +"プライベートでは、Kotlin/JSを使ったWebアプリの開発や、OSS活動にも積極的に関わっています。"
        }

        SkillRow {
            name = "Ruby"
            stars = 3
            since = "2016.06"

            +"業務でRuby on Railsを使い、タスクをこなしています。"
            +"大規模な機能追加・新規サービスの立ち上げ・DDD + Clean Architectureに沿ったリファクタの経験があります。"
        }

        SkillRow {
            name = "Javascript(ES6)"
            stars = 3
            since = "2016.06"

            +"業務でReactとReduxを使い、タスクをこなしています。"
            +"大規模な機能追加・新規サービスの立ち上げの経験があります。"
            +"また、Vue.jsを使って技術ブログを自作した経験もあります。"
        }
    }
}.create()

private val OtherSkills = Paragraph.create {
    +"その他: Java/C/TypeScript/PostgreSQL/Dart(Flutter)"
}
