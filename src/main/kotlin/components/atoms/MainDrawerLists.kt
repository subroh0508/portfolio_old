@file:Suppress("FunctionName")

package components.atoms

import materialcomponents.DrawerContent
import materialcomponents.List
import materialcomponents.ListItem
import materialcomponents.ListItemProps
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

external class MainDrawerListItem {
    var display: String
    var href: String
}

external interface MainDrawerListProps : WithClassName {
    var items: Array<MainDrawerListItem>
    var selectedIndex: Int
}

val MainDrawerLists = functionalComponent<MainDrawerListProps> { props ->
    DrawerContent {
        List {
            props.items.forEach { item -> StyledDrawerListItem { +item.display } }
        }
    }
}

fun RBuilder.StyledDrawerListItem(handler: StyledHandler<ListItemProps>) = (styled(ListItem)) {
    css {

    }

    handler()
}
