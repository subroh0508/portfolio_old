@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import materialcomponents.*
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

external interface TitleProps : WithClassName {
    var title: String
}

external interface SubtitleProps : WithClassName {
    var subtitle: String
}

val LargeTitle = functionalComponent<TitleProps> { props ->
    StyledTypographyHeadline4(props.className) { +props.title }
}

val LargeSubtitle = functionalComponent<SubtitleProps> { props ->
    StyledTypographyHeadline5(props.className) { +props.subtitle }
}

val Subtitle = functionalComponent<SubtitleProps> { props ->
    StyledTypographySubtitle1(props.className) { +props.subtitle }
}

private fun RBuilder.StyledTypographyHeadline4(className: String? = null, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        fontWeight = FontWeight.bold
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.headline4)
    attrs.tag = "h1"

    handler()
}

private fun RBuilder.StyledTypographyHeadline5(className: String? = null, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        color = Color(VAR_COLOR_TEXT_SECONDARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.headline5)
    attrs.tag = "h3"

    handler()
}

private fun RBuilder.StyledTypographySubtitle1(className: String? = null, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.subtitle1)
    attrs.tag = "div"

    handler()
}
