@file:Suppress("FunctionName")

package components.organisms

import components.atoms.MainDrawerHeader
import components.atoms.MainDrawerHeaderProps
import components.atoms.MainDrawerListProps
import components.atoms.MainDrawerLists
import components.atoms.MainDrawer
import react.FC
import react.PropsWithChildren
import react.child
import react.fc

external interface NavigationProps : PropsWithChildren, MainDrawerHeaderProps, MainDrawerListProps

val Navigation = FC<NavigationProps> { props ->
    MainDrawer {
        MainDrawerHeader {
            title = props.title
        }
        MainDrawerLists {
            selectedIndex = props.selectedIndex

            +props.children
        }
    }
}
