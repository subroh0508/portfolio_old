@file:JsModule("@rmwc/drawer")
@file:JsNonModule

package materialcomponents

import org.w3c.dom.events.Event
import react.ElementType
import react.PropsWithClassName

external interface DrawerProps : PropsWithClassName {
    var open: Boolean?
    var onClose: (Event) -> Unit
    var onOpen: (Event) -> Unit
    var dismissable: Boolean?
}

external val Drawer: ElementType<DrawerProps>
external val DrawerHeader: ElementType<PropsWithClassName>
external val DrawerTitle: ElementType<PropsWithClassName>
external val DrawerSubtitle: ElementType<PropsWithClassName>
external val DrawerContent: ElementType<PropsWithClassName>
external val DrawerAppContent: ElementType<PropsWithClassName>
