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
val AppFrameProps.toolbar: String
    get() = asDynamic()["classes"]["toolbar"] as String
val AppFrameProps.title: String
    get() = asDynamic()["classes"]["title"] as String
val AppFrameProps.subtitle: String
    get() = asDynamic()["classes"]["subtitle"] as String
val AppFrameProps.tabs: String
    get() = asDynamic()["classes"]["tabs"] as String
val AppFrameProps.tabsIndicator: String
    get() = asDynamic()["classes"]["tabsIndicator"] as String
val AppFrameProps.contents: String
    get() = asDynamic()["classes"]["contents"] as String
