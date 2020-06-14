package components.biography.profiles

import components.biography.root
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
import styles.profileStyle

val RBuilder.profile
    get() = childWithStyles<ProfileProps>("Profile", profileStyle) { props ->
        card(PaperStyle.root to props.root) {
            attrs.className = "card-root ${props.classNamePrefix}-card-root"

            cardHeader {
                attrs.title {
                    typography {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        props.title?.let(this::child)
                    }
                }
            }

            divider {
                attrs.className = "divider"
                attrs.variant = DividerVariant.middle
            }

            cardContent {
                attrs.className = "card-content ${props.classNamePrefix}-card-content"

                props.cardContent?.let(this::child)
            }
        }
    }
