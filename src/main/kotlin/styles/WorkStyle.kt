package styles

import kotlinx.css.*
import materialui.styles.StylesSet
import materialui.styles.palette.light

val projectStyle: StylesSet.() -> Unit = {
    "cardRoot" {
        gridColumnStart = GridColumnStart("1")
        gridColumnEnd = GridColumnEnd("13")

        descendants(".divider") {
            backgroundColor = Color("#e33830")
        }
    }
    "cardContent" {
        margin((theme.spacing.unit * 2).px)

        descendants(".panel-summary") {
            backgroundColor = theme.palette.secondary.light
        }

        descendants(".panel-detail") {
            backgroundColor = Color("#fafafa")
            display = Display.flex
            alignItems = Align.center

            children("img") {
                maxWidth = 400.px
                maxHeight = 250.px
                objectFit = ObjectFit.scaleDown
            }

            children(".paragraph") {
                marginLeft = 16.px

                descendants("p") {
                    fontWeight = FontWeight.w400
                    fontSize = 1.20.rem
                }

                descendants(".badges") {
                    paddingLeft = 40.px

                    descendants("img") {
                        marginRight = 4.px
                    }
                }
            }
        }
    }
}

val speakStyle: StylesSet.() -> Unit = {
    "cardRoot" {
        gridColumnStart = GridColumnStart("1")
        gridColumnEnd = GridColumnEnd("13")

        descendants(".divider") {
            backgroundColor = Color("#e33830")
        }
    }
    "cardContent" {
        descendants("p") {
            fontWeight = FontWeight.w400
            fontSize = 1.20.rem
        }
    }
}
