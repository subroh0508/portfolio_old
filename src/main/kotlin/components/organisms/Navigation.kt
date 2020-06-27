@file:Suppress("FunctionName")

package components.organisms

import components.atoms.MainDrawerHeader
import components.atoms.MainDrawerHeaderProps
import components.atoms.MainDrawerListProps
import components.atoms.MainDrawerLists
import materialcomponents.Drawer
import react.child
import react.functionalComponent

external interface NavigationProps : MainDrawerHeaderProps, MainDrawerListProps

val Navigation = functionalComponent<NavigationProps> { props ->
    Drawer {
        child(MainDrawerHeader) {
            attrs.title = props.title
        }
        child(MainDrawerLists) {
            attrs.items = props.items
            attrs.selectedIndex = props.selectedIndex
        }
    }
}


