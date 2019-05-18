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

            }
        }
    }