@file:JsModule("@rmwc/list")

package materialcomponents

import org.w3c.dom.events.Event
import react.RClass
import react.RProps
import react.dom.WithClassName

external interface ListProps : WithClassName {
    var avatarList: Boolean?
    var dense: Boolean?
    var nonInteractive: Boolean?
    var onAction: (Event) -> Unit
    var twoLine: Boolean?
    var vertical: Boolean?
    var wrapFocus: Boolean?
}

external val List: RClass<ListProps>

external interface ListItemProps : WithClassName {
    var activated: Boolean?
    var disable: Boolean?
    var ripple: Boolean?
    var selected: Boolean?
}

external val ListItem: RClass<ListItemProps>
external val ListItemText: RClass<WithClassName>
external val ListItemPrimaryText: RClass<WithClassName>
external val ListItemSecondaryText: RClass<WithClassName>
external val ListItemGraphic: RClass<WithClassName>
external val ListItemMeta: RClass<WithClassName>
external val ListGroup: RClass<WithClassName>
external val ListGroupSubheader: RClass<WithClassName>
external val ListDivider: RClass<WithClassName>
