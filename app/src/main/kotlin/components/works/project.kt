package components.works

import components.biography.cardContentStyle
import components.biography.cardRootStyle
import materialui.components.card.card
import materialui.components.cardcontent.cardContent
import materialui.components.cardheader.cardHeader
import materialui.components.divider.divider
import materialui.components.divider.enums.DividerVariant
import materialui.components.expansionpanel.expansionPanel
import materialui.components.expansionpaneldetails.expansionPanelDetails
import materialui.components.expansionpanelsummary.expansionPanelSummary
import materialui.components.icon.icon
import materialui.components.paper.enums.PaperStyle
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.*
import styles.projectStyle

val RBuilder.project
    get() = childWithStyles<ProjectProps>("Project", projectStyle) { props ->
        card(PaperStyle.root to props.cardRootStyle) {
            cardHeader {
                attrs.title {
                    typography {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        +"Project"
                    }
                }
            }

            divider {
                attrs.className = "divider"
                attrs.variant = DividerVariant.middle
            }

            cardContent(props.cardContentStyle) {
                expansionPanel {
                    expansionPanelSummary {
                        attrs.className = "panel-summary"
                        attrs.expandIcon { icon { +"expand_more" } }

                        typography {
                            attrs.variant = TypographyVariant.h6

                            +"Otonashi"
                        }
                    }

                    expansionPanelDetails {
                        attrs.className = "panel-detail"

                        img {
                            attrs.src = "./otonashi_overview.png"
                        }

                        div("paragraph") {
                            typography(p = true) {
                                +"　RDF用クエリ言語「SPARQL」のKotlinクライアントライブラリ。"
                            }
                            typography(p = true) {
                                +"　SPARQLのトリプル・パターンを"
                                code { +"subject be { predicate to object }" }
                                +"の形式で記述することができる。"
                            }
                            typography(p = true) {
                                +"　その他文字列・数値計算の関数に対応したクエリビルダー、特定SPARQLエンドポイントの語彙補完、語彙補完用クラスの自動生成Gradle Plugin等の機能を備える。"

                                ul {
                                    li { +"使用言語: Kotlin" }
                                    li {
                                        +"Github: "
                                        a {
                                            attrs.href = "https://github.com/subroh0508/otonashi"
                                            attrs.target = "_blank"

                                            +"subroh0508/otonashi"
                                        }
                                    }
                                }

                                span("badges") {
                                    a {
                                        attrs.href = "https://bintray.com/subroh0508/maven/Otonashi/_latestVersion"
                                        attrs.target = "_blank"

                                        img { attrs.src = "https://api.bintray.com/packages/subroh0508/maven/Otonashi/images/download.svg" }
                                    }
                                }
                            }
                        }
                    }
                }

                expansionPanel {
                    expansionPanelSummary {
                        attrs.className = "panel-summary"
                        attrs.expandIcon { icon { +"expand_more" } }

                        typography {
                            attrs.variant = TypographyVariant.h6

                            +"Kotlin Material UI"
                        }
                    }

                    expansionPanelDetails {
                        attrs.className = "panel-detail"

                        img {
                            attrs.src = "./kotlin_material_ui_overview.png"
                        }

                        div("paragraph") {
                            typography(p = true) {
                                +"　React.js向けUIライブラリ「"
                                a {
                                    attrs.href = "https://material-ui.com/"
                                    attrs.target = "_blank"

                                    +"Material UI"
                                }
                                +"」のKotlin/JS用ラッパーライブラリ。"
                            }
                            typography(p = true) {
                                +"　Material UIに含まれる100を超えるComponent、およびテーマカスタマイズ用関数をKotlin/JS上で即座に利用することができる。また、Kotlinの言語仕様に沿う形でMaterial UIを扱える拡張関数やインタフェースを提供する。"
                            }
                            typography(p = true) {
                                +"　このポートフォリオサイトもKotlin Material UIを利用し、制作している。"

                                ul {
                                    li { +"使用言語: Kotlin" }
                                    li {
                                        +"Github: "
                                        a {
                                            attrs.href = "https://github.com/subroh0508/kotlin-material-ui"
                                            attrs.target = "_blank"

                                            +"subroh0508/kotlin-material-ui"
                                        }
                                    }
                                }

                                span("badges") {
                                    a {
                                        attrs.href = "https://bintray.com/subroh0508/maven/Kotlin-Material-UI/_latestVersion"
                                        attrs.target = "_blank"

                                        img { attrs.src = "https://api.bintray.com/packages/subroh0508/maven/Kotlin-Material-UI/images/download.svg" }
                                    }
                                }
                            }
                        }
                    }
                }

                expansionPanel {
                    expansionPanelSummary {
                        attrs.className = "panel-summary"
                        attrs.expandIcon { icon { +"expand_more" } }

                        typography {
                            attrs.variant = TypographyVariant.h6

                            +"Kotori-Rate-Badge"
                        }
                    }

                    expansionPanelDetails {
                        attrs.className = "panel-detail"

                        div("paragraph") {
                            typography(p = true) {
                                +"　Github上のレポジトリのKotlin率を百分率で返すAPI。"
                                a {
                                    attrs.href = "https://shields.io/"
                                    attrs.target = "_blank"

                                    +"Shield.IO"
                                }
                                +"と併用すると、Kotlin率がひと目で分かるバッジがつけられるよ！嬉しい！"
                            }
                            typography(p = true) {
                                +"　因みにこのポートフォリオサイトのKotlin率は️"
                                img { attrs.src = "https://img.shields.io/badge/dynamic/json.svg?label=Kotori-Rate&colorB=fff98e&query=\$.kotori_rate&uri=https%3A%2F%2Fasia-northeast1-kotori-badge.cloudfunctions.net%2Fbadge%3Fowner%3Dsubroh0508%26repo%3Dportfolio&suffix=%" }
                                +"だ！100%目指して頑張るぞ！"
                            }
                            typography(p = true) {
                                +"　JavaからKotlinへの移行を進めているならば、これを使うとQoLが上がること間違いなし💪"

                                ul {
                                    li { +"使用言語: Javascript" }
                                    li {
                                        +"Github: "
                                        a {
                                            attrs.href = "https://github.com/subroh0508/Kotori-Rate-Badge"
                                            attrs.target = "_blank"

                                            +"subroh0508/Kotori-Rate-Badge"
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
