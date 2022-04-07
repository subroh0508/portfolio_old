@file:Suppress("FunctionName")

package components.organisms

import components.atoms.MainDrawerHeader
import components.atoms.MainDrawerHeaderProps
import components.atoms.MainDrawerListProps
import components.atoms.MainDrawerLists
import components.atoms.MainDrawer
import react.child
import react.fc

external interface NavigationProps : MainDrawerHeaderProps, MainDrawerListProps

val Navigation = fc<NavigationProps> { props ->
    child(MainDrawer) {
        child(MainDrawerHeader) {
            attrs.title = props.title
        }
        child(MainDrawerLists) {
            attrs.selectedIndex = props.selectedIndex

            props.children()
        }
    }
}
