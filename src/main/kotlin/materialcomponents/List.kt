@file:JsModule("@rmwc/list")
@file:JsNonModule

package materialcomponents

import org.w3c.dom.events.Event
import react.ElementType
import styled.StyledProps

external interface ListProps : StyledProps {
    var avatarList: Boolean?
    var dense: Boolean?
    var nonInteractive: Boolean?
    var onAction: (Event) -> Unit
    var twoLine: Boolean?
    var vertical: Boolean?
    var wrapFocus: Boolean?
}

external val List: ElementType<ListProps>

external interface ListItemProps : StyledProps {
    var activated: Boolean?
    var disable: Boolean?
    var ripple: Boolean?
    var selected: Boolean?
}

external val ListItem: ElementType<ListItemProps>
external val ListItemText: ElementType<StyledProps>
external val ListItemPrimaryText: ElementType<StyledProps>
external val ListItemSecondaryText: ElementType<StyledProps>
external val ListItemGraphic: ElementType<StyledProps>
external val ListItemMeta: ElementType<StyledProps>
external val ListGroup: ElementType<StyledProps>
external val ListGroupSubheader: ElementType<StyledProps>
external val ListDivider: ElementType<StyledProps>
