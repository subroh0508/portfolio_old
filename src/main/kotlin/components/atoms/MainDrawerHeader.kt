@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.height
import kotlinx.css.px
import materialcomponents.DrawerHeader
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

external interface MainDrawerHeaderProps : WithClassName {
    var title: String
}

val MainDrawerHeader = functionalComponent<MainDrawerHeaderProps> { props ->
    StyledMainDrawerHeader(props.className) { +props.title }
}

private fun RBuilder.StyledMainDrawerHeader(className: String?, handler: StyledHandler<WithClassName>) = (styled(DrawerHeader)) {
    css {
        className?.let(classes::add)
        height = 100.px
    }

    handler()
}
