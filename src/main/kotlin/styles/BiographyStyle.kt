package styles

import kotlinx.css.*
import kotlinx.css.FontWeight.Companion.w400
import materialui.styles.StylesSet

val biographyStyle: StylesSet.() -> Unit = {
    "root" {
        display = Display.flex
        width = 100.pct
        flexDirection = FlexDirection.column
        alignItems = Align.center

        children("div") {
            nthChild("1") {
                margin((theme.spacing.unit * 4).px)
            }
            nthChild("2") {
                margin(
                    top = (theme.spacing.unit * 4).px,
                    bottom = (theme.spacing.unit * 4).px,
                    right = (theme.spacing.unit * 16).px,
                    left = (theme.spacing.unit * 4).px
                )
            }
        }
    }
}

val aboutStyle: StylesSet.() -> Unit = {
    "cardContent" {
        display = Display.flex
        maxWidth = 720.px
        alignItems = Align.center
    }
    "avatar" {
        height = 240.px
        width = 240.px
    }
    "paragraph" {
        paddingLeft = 16.px

        children("p") {
            fontWeight = w400
            fontSize = 1.20.rem

            firstChild {
                paddingBottom = 16.px
            }
        }
    }
}


val profileStyle: StylesSet.() -> Unit = {
    "cardContent" {
        display = Display.flex
        maxWidth = 690.px
        alignItems = Align.center
    }
    "paragraph" {
        children("p") {
            fontWeight = w400
            fontSize = 1.20.rem
        }
    }
    "googleMap" {
        paddingLeft = 16.px
    }
}

val googleMapStyle: StylesSet.() -> Unit = {
    "root" {
        width = 350.px
        height = 350.px
    }
}
