package reactswipableviews

import react.RBuilder
import react.RClass
import react.RProps

@JsModule("react-swipeable-views")
private external val reactSwipeableViewModule: dynamic

external interface ReactSwipeableProps : RProps {
    var index: Int
    var onChangeIndex: (Int, Int, ChangeReason) -> Unit
}

fun ReactSwipeableProps.onChangeIndex(block: (Int, Int?, ReasonType?) -> Unit) {
    onChangeIndex = { index: Int, indexLatest: Int, reason: ChangeReason ->
        block(index, indexLatest, ReasonType.valueOf(reason.reason))
    }
}

fun ReactSwipeableProps.onChangeIndex(block: (Int, Int?) -> Unit) {
    onChangeIndex = { index: Int, indexLatest: Int, _ -> block(index, indexLatest) }
}

fun ReactSwipeableProps.onChangeIndex(block: (Int) -> Unit) {
    onChangeIndex = { index: Int, _, _ -> block(index) }
}

external interface ChangeReason {
    var reason: String
}

@Suppress("EnumEntryName")
enum class ReasonType {
    swipe, focus
}

val RBuilder.swipeableViews: RClass<ReactSwipeableProps>
    get() = reactSwipeableViewModule.default as RClass<ReactSwipeableProps>
