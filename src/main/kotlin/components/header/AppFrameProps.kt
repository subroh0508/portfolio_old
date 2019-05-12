package components.header

import react.RProps
import react.ReactElement

external interface AppFrameProps : RProps {
    var views: Array<ReactElement>
}

val AppFrameProps.root: String
    get() = asDynamic()["classes"]["root"] as String
val AppFrameProps.appBar: String
    get() = asDynamic()["classes"]["appBar"] as String
val AppFrameProps.tabs: String
    get() = asDynamic()["classes"]["tabs"] as String
val AppFrameProps.tabsIndicator: String
    get() = asDynamic()["classes"]["tabsIndicator"] as String
val AppFrameProps.contents: String
    get() = asDynamic()["classes"]["contents"] as String
