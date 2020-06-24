@file:JsModule("@rmwc/drawer")

package materialcomponents

import org.w3c.dom.events.Event
import react.RClass
import react.dom.WithClassName

external interface DrawerProps : WithClassName {
    var open: Boolean?
    var onClose: (Event) -> Unit
    var onOpen: (Event) -> Unit
    var dismissable: Boolean?
}

external val Drawer: RClass<DrawerProps>
external val DrawerHeader: RClass<WithClassName>
external val DrawerTitle: RClass<WithClassName>
external val DrawerSubtitle: RClass<WithClassName>
external val DrawerContent: RClass<WithClassName>
external val DrawerAppContent: RClass<WithClassName>
