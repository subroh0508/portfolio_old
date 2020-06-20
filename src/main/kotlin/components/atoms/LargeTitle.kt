@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import materialcomponents.Typography
import materialcomponents.TypographyProps
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styled

external interface LargeTitleProps : StyledProps, WithClassName {
    var title: String
}

val LargeTitle = functionalComponent<LargeTitleProps> { props ->
    StyledTypographyHeadline4(props.className) { +props.title }
}

external interface LargeSubtitleProps: WithClassName {
    var subtitle: String
}

val LargeSubtitle = functionalComponent<LargeSubtitleProps> { props ->
    StyledTypographyHeadline5(props.className) { +props.subtitle }
}

private fun RBuilder.StyledTypographyHeadline4(className: String? = null, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        fontWeight = FontWeight.bold
        color = Color("mdc-theme-text-primary-on-dark".toCustomProperty())
    }

    attrs.use = "headline4"
    attrs.tag = "h1"

    handler()
}

private fun RBuilder.StyledTypographyHeadline5(className: String? = null, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        color = Color("mdc-theme-text-primary-on-dark".toCustomProperty())
    }

    attrs.use = "headline5"
    attrs.tag = "h3"

    handler()
}