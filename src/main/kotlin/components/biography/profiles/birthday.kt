package components.biography.profiles

import kotlinext.js.jsObject
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.dom.*
import styles.birthdayStyle

fun RBuilder.birthday(handler: ProfileProps.() -> Unit) = profile {
    attrs.classNamePrefix = "birthday"
    attrs.title { +"Birthday: 1995/5/8" }

    attrs.cardContent("Birthday", birthdayStyle) { props: BirthdayProps ->
        div(props.root) {
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                span { +"同じ誕生日の有名人" }

                ul {
                    people.forEach { person ->
                        li {
                            a { attrs.href = person.href; attrs.target = "_target"; +person.name }
                            +" (${person.info})"
                        }
                    }
                }
            }

            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                span { +"この日のできごと" }

                ul {
                    events.forEach { event ->
                        li { +"${event.year} - ${event.detail}" }
                    }
                }
            }
        }
    }

    attrs.handler()
}

external class FamousPerson {
    var name: String
    var href: String
    var info: String
}

val people: List<FamousPerson> = listOf(
    jsObject {
        name = "ハリー・S・トルーマン"
        href = "https://ja.wikipedia.org/wiki/%E3%83%8F%E3%83%AA%E3%83%BC%E3%83%BBS%E3%83%BB%E3%83%88%E3%83%AB%E3%83%BC%E3%83%9E%E3%83%B3"
        info = "1884年 / 米国第33代大統領"
    },
    jsObject {
        name = "曙太郎"
        href = "https://ja.wikipedia.org/wiki/%E6%9B%99%E5%A4%AA%E9%83%8E"
        info = "1969年 / 第64代横綱"
    },
    jsObject {
        name = "荒川弘"
        href = "https://ja.wikipedia.org/wiki/%E8%8D%92%E5%B7%9D%E5%BC%98"
        info = "1973年 / 漫画家"
    },
    jsObject {
        name = "たかはし智秋"
        href = "https://ja.wikipedia.org/wiki/%E3%81%9F%E3%81%8B%E3%81%AF%E3%81%97%E6%99%BA%E7%A7%8B"
        info = "1977年 / 声優"
    }
)

external class HistoricalEvent {
    var detail: String
    var year: String
}

val events: List<HistoricalEvent> = listOf(
    jsObject {
        year = "1429年"
        detail = "百年戦争: ジャンヌ・ダルク率いるフランス軍がオルレアン市を解放。"
    },
    jsObject {
        year = "1942年"
        detail = "第二次世界大戦・珊瑚海海戦: 日本海軍と連合国海軍の間で史上初の航空母艦同士の海戦が勃発。"
    },
    jsObject {
        year = "1970年"
        detail = "Beatlesの最後のアルバム『Let It Be』発売。"
    }
)