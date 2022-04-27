@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.ComposableParagraph
import components.atoms.LargeTitle
import components.organisms.CardFrame
import components.organisms.SkillRow
import components.organisms.SkillTable
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.HTMLElement
import react.VFC
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

val SkillCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Skill")

        MainSkills()
        OtherSkills()
    }

    CardFrame {
        div {
            ref { containerRef.current = it }
        }
    }
}

@Composable
private fun MainSkills() {
    SkillTable {
        SkillRow(
            name = "Kotlin",
            starCount = 5,
            since = "2016.02",
        ) {
            Text("v1.0が出る直前に業務で触れて以来、Androidアプリの開発で使い続けています。")
            Text("プライベートでは、Kotlin/JSを使ったWebアプリの開発や、OSS活動にも積極的に関わっています。")
        }

        SkillRow(
            name = "Ruby",
            starCount = 3,
            since = "2016.06",
        ) {
            Text("業務でRuby on Railsを使い、タスクをこなしています。")
            Text("大規模な機能追加・新規サービスの立ち上げ・DDD + Clean Architectureに沿ったリファクタの経験があります。")
        }

        SkillRow(
            name = "Javascript(ES6)",
            starCount = 3,
            since = "2016.06",
        ) {
            Text("業務でReactとReduxを使い、タスクをこなしています。")
            Text("大規模な機能追加・新規サービスの立ち上げの経験があります。")
            Text("また、Vue.jsを使って技術ブログを自作した経験もあります。")
        }
    }
}

@Composable
private fun OtherSkills() {
    ComposableParagraph {
        Text("その他: Java/C/TypeScript/PostgreSQL/Dart(Flutter)")
    }
}
