package components.biography

import materialui.components.avatar.avatar
import materialui.components.avatar.enum.AvatarStyle
import materialui.components.card.card
import materialui.components.cardcontent.cardContent
import materialui.components.cardheader.cardHeader
import materialui.components.divider.divider
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.aboutStyle

val RBuilder.about
    get() = childWithStyles<AboutProps>("About", aboutStyle) { props ->
        card {
            cardHeader {
                attrs.title {
                    typography {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        +"About Me"
                    }
                }
            }

            divider { }

            cardContent(props.cardContentStyle) {
                avatar(AvatarStyle.root to props.avatarStyle) {
                    attrs.src = "./avatar.jpg"

                }

                div(props.paragraphStyle) {
                    typography(p = true) {
                        attrs.variant = TypographyVariant.h6

                        +"　Kotlinを愛してやまない、日本酒🍶とライブ🎤が生き甲斐なAndroid Developer。"
                        +"諸々の事情で、Ruby on Rails・React.jsでのWeb開発にも携わる。"
                    }

                    typography(p = true) {
                        attrs.variant = TypographyVariant.h6

                        +"　RubyやJSの自由な世界観も好き。だけどやっぱり型が欲しい＞＜"
                    }
                }
            }
        }
    }