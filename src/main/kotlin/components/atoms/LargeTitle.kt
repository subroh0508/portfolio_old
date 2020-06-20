@file:Suppress("FunctionName")

package components.atoms

import materialcomponents.Typography
import materialcomponents.TypographyProps
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.styled

external interface LargeTitleProps : WithClassName {
    var title: String
}

val LargeTitle = functionalComponent<LargeTitleProps> { props ->
    StyledTypographyHeadline3 { +props.title }
}

external interface LargeSubtitleProps: WithClassName {
    var subtitle: String
}

val LargeSubtitle = functionalComponent<LargeSubtitleProps> { props ->
    StyledTypographyHeadline5 { +props.subtitle }
}

private fun RBuilder.StyledTypographyHeadline3(handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    attrs.use = "headline3"
    attrs.tag = "h1"

    handler()
}

private fun RBuilder.StyledTypographyHeadline5(handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    attrs.use = "headline5"
    attrs.tag = "h3"

    handler()
}
