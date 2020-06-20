@file:Suppress("FunctionName")

import materialcomponents.Card
import materialcomponents.CardProps
import materialcomponents.Typography
import react.RBuilder
import react.dom.render
import kotlin.browser.document
import kotlinext.js.require
import kotlinx.css.*
import kotlinx.html.DIV
import styled.*

fun main() {
    injectGlobal {
        body {
            backgroundColor = Color("#121212")
        }
    }

    require("@material/card/dist/mdc.card.min.css")
    require("@material/typography/dist/mdc.typography.min.css")
    require("@material/theme/dist/mdc.theme.min.css")

    render(document.getElementById("root")) {
        StyledCard {
            CardContainer {
                Typography {
                    attrs.use = "headline6"
                    attrs.tag = "h2"

                    +"Title"
                }
                Typography {
                    attrs.use = "subtitle2"
                    attrs.tag = "h3"

                    +"subtitle"
                }

                Typography {
                    attrs.use = "body1"
                    attrs.tag = "div"

                    +"Visit ten places on our planet that are undergoing the biggest changes today."
                }
            }
        }
    }
}

fun RBuilder.StyledCard(handler: StyledHandler<CardProps>) = (styled(Card)) {
    css {
        width = 21.rem
    }
    handler()
}

fun RBuilder.CardContainer(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        padding(0.rem, 1.rem, 1.rem, 1.rem)
    }
    handler()
}
