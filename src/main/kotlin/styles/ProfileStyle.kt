package styles

import kotlinx.css.*
import materialui.styles.StylesSet

val profileStyle: StylesSet.() -> Unit = {
    "root" {
        +"card-root" {
            descendants(".divider") {
                backgroundColor = Color("#3b91c4")
            }

            descendants(".card-content") {
                children("div") {
                    nthChild("1") {
                        display = Display.flex
                        alignItems = Align.center
                    }
                }
            }
        }
        +"birthday-card-root" {
            gridColumnStart = GridColumnStart("1")
            gridColumnEnd = GridColumnEnd("9")
        }
        +"from-card-root" {
            gridColumnStart = GridColumnStart("3")
            gridColumnEnd = GridColumnEnd("13")
        }
    }

    "paragraph" {
        children("p") {
            fontWeight = FontWeight.w400
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

val birthdayStyle: StylesSet.() -> Unit = {
    "root" {
        descendants("p") {
            descendants("li") {
                fontWeight = FontWeight.w400
                fontSize = 1.20.rem
            }

            nthChild("1") {
                margin(bottom = (theme.spacing.unit * 4).px)
            }
        }
    }
}

val fromStyle: StylesSet.() -> Unit = {
    "paragraph" {
        children("p") {
            fontWeight = FontWeight.w400
            fontSize = 1.20.rem
        }

        children("div") {
            margin(top = (theme.spacing.unit * 4).px)
        }
    }
    "googleMap" {
        paddingLeft = 16.px
    }
}