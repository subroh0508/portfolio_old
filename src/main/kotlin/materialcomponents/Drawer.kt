@file:JsModule("@rmwc/drawer")
@file:JsNonModule

package materialcomponents

import org.w3c.dom.events.Event
import react.ElementType
import styled.StyledProps

external interface DrawerProps : StyledProps {
    var open: Boolean?
    var onClose: (Event) -> Unit
    var onOpen: (Event) -> Unit
    var dismissable: Boolean?
}

external val Drawer: ElementType<DrawerProps>
external val DrawerHeader: ElementType<StyledProps>
external val DrawerTitle: ElementType<StyledProps>
external val DrawerSubtitle: ElementType<StyledProps>
external val DrawerContent: ElementType<StyledProps>
external val DrawerAppContent: ElementType<StyledProps>
