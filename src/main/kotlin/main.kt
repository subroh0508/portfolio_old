@file:Suppress("FunctionName")

import kotlinx.css.rem
import kotlinx.css.width
import materialcomponents.Card
import materialcomponents.CardProps
import materialcomponents.Typography
import react.RBuilder
import react.ReactElement
import react.dom.render
import kotlin.browser.document
import kotlinext.js.require
import kotlinx.css.padding
import kotlinx.html.DIV
import styled.*

fun main() {
    require("@material/card/dist/mdc.card.min.css")
    require("@material/typography/dist/mdc.typography.min.css")

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
