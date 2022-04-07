@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import materialcomponents.*
import react.RBuilder
import react.fc
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styled

external interface TitleProps : StyledProps {
    var title: String
    var tag: String?
}

external interface SubtitleProps : StyledProps {
    var subtitle: String
    var tag: String?
}

val LargeTitle = fc<TitleProps> { props ->
    StyledTypographyHeadline4(props.className.unsafeCast<String>(), props.tag) { +props.title }
}

val LargeSubtitle = fc<SubtitleProps> { props ->
    StyledTypographyHeadline5(props.className.unsafeCast<String>(), props.tag) { +props.subtitle }
}

val Subtitle = fc<SubtitleProps> { props ->
    StyledTypographyHeadline6(props.className.unsafeCast<String>(), props.tag) { +props.subtitle }
}

private fun RBuilder.StyledTypographyHeadline4(
    className: String? = null, tag: String? = null,
    handler: StyledHandler<TypographyProps>
) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        fontWeight = FontWeight.bold
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.headline4)
    attrs.tag = tag ?: "h2"

    handler()
}

private fun RBuilder.StyledTypographyHeadline5(
    className: String? = null, tag: String? = null,
    handler: StyledHandler<TypographyProps>
) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        color = Color(VAR_COLOR_TEXT_SECONDARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.headline5)
    attrs.tag = tag ?: "h3"

    handler()
}

private fun RBuilder.StyledTypographyHeadline6(
    className: String? = null, tag: String? = null,
    handler: StyledHandler<TypographyProps>
) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        fontWeight = FontWeight.normal
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.headline6)
    attrs.tag = tag ?: "h4"

    handler()
}
