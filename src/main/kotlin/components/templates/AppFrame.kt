@file:Suppress("FunctionName")

package components.templates

import components.atoms.MAIN_DRAWER_WIDTH
import components.atoms.MainDrawerListItem
import components.atoms.MainDrawerListItemProps
import components.atoms.title
import components.organisms.CARD_FRAME_CLASS
import components.organisms.Navigation
import kotlinx.css.*
import kotlinx.html.DIV
import react.RBuilder
import react.RHandler
import react.child
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledDOMBuilder
import styled.css
import styled.styledDiv

external interface AppFrameProps : WithClassName {
    var drawerItems: Array<out RHandler<MainDrawerListItemProps>>
}

fun AppFrameProps.navItems(vararg navItems: RHandler<MainDrawerListItemProps>) { this.drawerItems = navItems }

val AppFrame = functionalComponent<AppFrameProps> { props ->
    StyledRowDiv {
        child(Navigation) {
            attrs.title("Subroh Nishikori's", "Portfolio")
            attrs.selectedIndex = 0

            props.drawerItems.forEach {
                child(MainDrawerListItem, handler = it)
            }
        }

        StyledContent { props.children() }
    }
}

private fun RBuilder.StyledRowDiv(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        display = Display.flex
        height = 100.pct
    }

    handler()
}

private fun RBuilder.StyledContent(handler: StyledDOMBuilder<DIV>.() -> Unit) = styledDiv {
    css {
        flex(1.0)
        marginLeft = MAIN_DRAWER_WIDTH

        children(".$CARD_FRAME_CLASS") {
            marginTop = 64.px
        }
    }

    handler()
}
