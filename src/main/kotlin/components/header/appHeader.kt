package components.header

import materialui.components.appbar.appBar
import materialui.components.appbar.enums.AppBarColor
import materialui.components.toolbar.toolbar
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import materialui.styles.childWithStyles
import react.RBuilder
import react.dom.div
import styles.headerStyle

val RBuilder.appHeader
    get() = childWithStyles<HeaderProps>("header", headerStyle) { props ->
        div(props.root) {
            appBar {
                attrs.className = props.appBar
                attrs.color = AppBarColor.primary

                toolbar {
                    typography {
                        attrs.variant = TypographyVariant.h6
                        attrs.color = TypographyColor.inherit
                    }
                    +"Subroh Nishikori's Portfolio"
                }
            }
        }
    }
