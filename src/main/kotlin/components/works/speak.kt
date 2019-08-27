package components.works

import components.biography.cardContentStyle
import components.biography.cardRootStyle
import materialui.components.card.card
import materialui.components.cardcontent.cardContent
import materialui.components.cardheader.cardHeader
import materialui.components.divider.divider
import materialui.components.divider.enums.DividerVariant
import materialui.components.paper.enums.PaperStyle
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.*
import styles.speakStyle

val RBuilder.speak
    get() = childWithStyles<SpeakProps>("Speak", speakStyle) { props ->
        card(PaperStyle.root to props.cardRootStyle) {
            cardHeader {
                attrs.title {
                    typography {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        +"Speak"
                    }
                }
            }

            divider {
                attrs.className = "divider"
                attrs.variant = DividerVariant.middle
            }

            cardContent(props.cardContentStyle) {
                div {
                    typography(p = true) {
                        span { +"2019年" }
                        ul {
                            li {
                                b { +"DroidKaigi 2019:" }
                                +" 「Spek2+MockK+JaCoCoでイケてるUnit Test環境を手に入れろ！」 "

                                +"("
                                a {
                                    attrs.href = "https://droidkaigi.jp/2019/timetable/70535"
                                    attrs.target = "_blank"

                                    +"公式サイト"
                                }
                                +")"
                            }
                            li {
                                b { +"Kotlin愛好会 Vol.10:" }
                                +" 「Kotlinでクエリ言語のクライアントを作った話」 "

                                +"("
                                a {
                                    attrs.href =
                                        "https://speakerdeck.com/subroh0508/kotlindekueriyan-yu-falsekuraiantowozuo-tutahua"
                                    attrs.target = "_blank"

                                    +"SpeakerDeck"
                                }
                                +")"
                            }
                            li {
                                b { +"アイマスハッカソン2019 in 名古屋:" }
                                +" 「Otonashi meets im@sparql」 "

                                +"("
                                a {
                                    attrs.href = "https://speakerdeck.com/subroh0508/otonashi-meets-im-at-sparql"
                                    attrs.target = "_blank"

                                    +"SpeakerDeck"
                                }
                                +")"
                            }
                            li {
                                b { +"IM@S Engineer Talks 2019:" }
                                +" 「小鳥さんとKotlinを勉強できるサイトを100%Kotlinで作る」 "

                                +"("
                                a {
                                    attrs.href = "https://youtu.be/8oB-JudUejE?t=6375"
                                    attrs.target = "_blank"

                                    +"YouTube"
                                }
                                +")"
                            }
                            li {
                                b { +"Kotlin Fest 2019:" }
                                +"「フロントエンドもKotlinで書きたい！ -WebページをKotlin/JSで作った軌跡-」"

                                +"("
                                a {
                                    attrs.href = "https://speakerdeck.com/subroh0508/jsdezuo-tutagui-ji"
                                    attrs.target = "_blank"

                                    +"SpeakerDeck"
                                }
                                +")"
                            }
                        }

                        span { +"2018年" }
                        ul {
                            li {
                                b { +"高専カンファレンス in 東京 2018:" }
                                +" 「Flutterで生み出せ圧倒的成果💪 -クロスプラットフォーム開発の未来-」 "

                                +"("
                                a {
                                    attrs.href = "https://www.slideshare.net/subroh_0508/flutter-105984178"
                                    attrs.target = "_blank"

                                    +"SlideShare"
                                }
                                +")"
                            }
                        }
                    }
                }
            }
        }
    }