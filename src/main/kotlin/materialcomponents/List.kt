@file:JsModule("@rmwc/list")
@file:JsNonModule

package materialcomponents

import org.w3c.dom.events.Event
import react.ElementType
import react.PropsWithClassName

external interface ListProps : PropsWithClassName {
    var avatarList: Boolean?
    var dense: Boolean?
    var nonInteractive: Boolean?
    var onAction: (Event) -> Unit
    var twoLine: Boolean?
    var vertical: Boolean?
    var wrapFocus: Boolean?
}

external val List: ElementType<ListProps>

external interface ListItemProps : PropsWithClassName {
    var activated: Boolean?
    var disable: Boolean?
    var ripple: Boolean?
    var selected: Boolean?
}

external val ListItem: ElementType<ListItemProps>
external val ListItemText: ElementType<PropsWithClassName>
external val ListItemPrimaryText: ElementType<PropsWithClassName>
external val ListItemSecondaryText: ElementType<PropsWithClassName>
external val ListItemGraphic: ElementType<PropsWithClassName>
external val ListItemMeta: ElementType<PropsWithClassName>
external val ListGroup: ElementType<PropsWithClassName>
external val ListGroupSubheader: ElementType<PropsWithClassName>
external val ListDivider: ElementType<PropsWithClassName>
