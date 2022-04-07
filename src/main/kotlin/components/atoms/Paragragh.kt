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

val Paragraph = fc<StyledProps> { props ->
    StyledBody1(props.className.unsafeCast<String>()) { props.children() }
}

private fun RBuilder.StyledBody1(className: String?, handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        className?.let(classes::add)
        fontWeight = FontWeight.normal
        color = Color(VAR_COLOR_TEXT_SECONDARY_ON_DARK.toCustomProperty())
    }

    attrs.use(TypographyUse.body1)
    attrs.tag = "p"

    handler()
}
