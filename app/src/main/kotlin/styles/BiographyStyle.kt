package styles

import components.biography.maps.MapProps
import components.biography.profiles.BirthdayProps
import components.biography.profiles.FromProps
import components.biography.profiles.ProfileProps
import kotlinx.css.*
import materialui.styles.StylesBuilder
import react.RProps

val profileStyle: StylesBuilder<ProfileProps>.() -> Unit = {
    "root" {
        +"card-root" {
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

            descendants(".divider") {
                backgroundColor = Color("#3b91c4")
            }
        }
        +"from-card-root" {
            gridColumnStart = GridColumnStart("3")
            gridColumnEnd = GridColumnEnd("13")

            descendants(".divider") {
                backgroundColor = Color("#3b91c4")
            }
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

val googleMapStyle: StylesBuilder<MapProps>.() -> Unit = {
    "root" {
        width = 350.px
        height = 350.px
    }
}

val birthdayStyle: StylesBuilder<BirthdayProps>.() -> Unit = {
    "root" {
        descendants("p") {
            descendants("li") {
                fontWeight = FontWeight.w400
                fontSize = 1.20.rem
            }

            nthChild("1") {
                margin(bottom = (theme.spacing(4)).px)
            }
        }
    }
}

val fromStyle: StylesBuilder<FromProps>.() -> Unit = {
    "paragraph" {
        children("p") {
            fontWeight = FontWeight.w400
            fontSize = 1.20.rem
        }

        children("div") {
            margin(top = (theme.spacing(4)).px)
        }
    }
    "googleMap" {
        paddingLeft = 16.px
    }
}
