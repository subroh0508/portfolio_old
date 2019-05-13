package components.biography

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
import styles.profileStyle

val RBuilder.profile
    get() = childWithStyles<ProfileProps>("Profile", profileStyle) { props ->
        card {
            cardHeader {
                attrs.title {
                    typography {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        +"Profile"
                    }
                }
            }

            divider { }

            cardContent(props.cardContentStyle) {
                div(props.paragraphStyle) {
                    typography(p = true) {
                        attrs.variant = TypographyVariant.h6

                        +"生年月日: 1995年5月8日"
                    }
                    typography(p = true) {
                        attrs.variant = TypographyVariant.h6

                        +"出身: 東京・伊豆大島"
                    }
                    typography(p = true) {
                        attrs.variant = TypographyVariant.h6

                        +"在住: 東京・秋葉原"
                    }
                }
            }
        }
    }