@file:Suppress("FunctionName")

package components.templates

import components.atoms.*
import components.organisms.CARD_FRAME_CLASS
import components.organisms.Navigation
import csstype.Display
import csstype.number
import csstype.pct
import csstype.px
import emotion.styled.styled
import kotlinx.js.jso
import react.FC
import react.PropsWithChildren
import react.PropsWithClassName
import react.dom.html.ReactHTML.div

external interface AppFrameProps : PropsWithChildren, PropsWithClassName {
    var drawerProps: Array<out MainDrawerListItemProps>
}

fun AppFrameProps.navItems(vararg block: MainDrawerListItemProps.() -> Unit) {
    this.drawerProps = block.map { jso(it) }.toTypedArray()
}

val AppFrame = FC<AppFrameProps> { props ->
    StyledRowDiv {
        Navigation {
            title("Subroh Nishikori's", "Portfolio")
            selectedIndex = 0

            props.drawerProps.forEach { drawerProps ->
                MainDrawerListItem {
                    +drawerProps
                }
            }
        }

        StyledContent {
            +props.children

            Footer {}
        }
    }
}

private val StyledRowDiv = div.styled { _, _ ->
    display = Display.flex
    height = 100.pct
}

private val StyledContent = div.styled { _, _ ->
    flexGrow = number(1.0)
    marginLeft = 224.px // MAIN_DRAWER_WIDTH

    CARD_FRAME_CLASS {
        marginTop = 64.px
    }
}
