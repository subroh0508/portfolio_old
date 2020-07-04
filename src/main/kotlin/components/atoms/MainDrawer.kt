@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import materialcomponents.Drawer
import materialcomponents.DrawerProps
import materialcomponents.VAR_COLOR_BACKGROUND
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

val MainDrawer = functionalComponent<WithClassName> { props ->
    StyledDrawer(props.className) { props.children() }
}

private fun RBuilder.StyledDrawer(className: String? = null, handler: StyledHandler<DrawerProps>) = (styled(Drawer)) {
    css {
        className?.let(classes::add)
        color = Color.white
        backgroundColor = Color(VAR_COLOR_BACKGROUND.toCustomProperty())
        borderColor = Color.white.withAlpha(0.12)
    }

    handler()
}
