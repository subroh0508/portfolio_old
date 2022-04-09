@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.organisms.CardFrame
import components.organisms.SkillTable
import react.Props
import react.VFC
import react.create
import react.createElement

val SkillCard = VFC {
    CardFrame {
        LargeTitle {
            title = "Skill"
        }

        +MainSkills
        +OtherSkills
    }
}

private val MainSkills = createElement<Props> {
    SkillTable({
        attrs.name = "Kotlin"
        attrs.stars = 5
        attrs.since = "2016.02"

        +"v1.0が出る直前に業務で触れて以来、Androidアプリの開発で使い続けています。"
        +"プライベートでは、Kotlin/JSを使ったWebアプリの開発や、OSS活動にも積極的に関わっています。"
    }, {
        attrs.name = "Ruby"
        attrs.stars = 3
        attrs.since = "2016.06"

        +"業務でRuby on Railsを使い、タスクをこなしています。"
        +"大規模な機能追加・新規サービスの立ち上げ・DDD + Clean Architectureに沿ったリファクタの経験があります。"
    }, {
        attrs.name = "Javascript(ES6)"
        attrs.stars = 3
        attrs.since = "2016.06"

        +"業務でReactとReduxを使い、タスクをこなしています。"
        +"大規模な機能追加・新規サービスの立ち上げの経験があります。"
        +"また、Vue.jsを使って技術ブログを自作した経験もあります。"
    })
}

private val OtherSkills = Paragraph.create {
    +"その他: Java/C/TypeScript/PostgreSQL/Dart(Flutter)"
}
