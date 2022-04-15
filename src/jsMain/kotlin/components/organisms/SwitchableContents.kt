@file:Suppress("FunctionName")

package components.organisms

import components.molecules.*
import csstype.*
import emotion.css.keyframes
import emotion.react.css
import history.Location
import kotlinx.js.jso
import react.*
import react.dom.html.ReactHTML.div
import react.router.useLocation
import react.router.useNavigate
import utilities.*

external interface SwitchableContentsProps : PropsWithChildren, PropsWithClassName {
    var titles: Array<out String>
}

fun SwitchableContentsProps.titles(vararg title: String) { titles = title }

val SwitchableContents = FC<SwitchableContentsProps> { props ->
    SwitchableContentTitle {
        titles = props.titles
    }

    Children.toArray(props.children).forEachIndexed { i, child ->
        SwitchableContent {
            index = i
            lastIndex = props.titles.size

            +child
        }
    }
}

@Suppress("UNCHECKED_CAST_TO_EXTERNAL_INTERFACE")
private val Location.switcherState: SwitcherState? get() = state as? SwitcherState

private fun PropertiesBuilder.slideInRight() = slideIn(true)
private fun PropertiesBuilder.slideInLeft() = slideIn(false)

private fun PropertiesBuilder.slideIn(right: Boolean) {
    animationName = keyframes {
        from { opacity = number(0.0); transform = translatex((if (right) 24 else -24).px) }
        to { opacity = number(1.0); transform = translatex(0.px) }
    }
    animationDuration = 0.5.s
    animationFillMode = AnimationFillMode.forwards
}

private val SwitchableContentTitle = FC<SwitchableContentsProps> { props ->
    val location = useLocation()
    val currentIndex = location.getPageQuery()

    Switcher {
        css {
            ".$CHEVRON_LEFT_CLASS_NAME" {
                visibility = if (currentIndex == 0) Visibility.hidden else Visibility.visible
            }
            ".$CHEVRON_RIGHT_CLASS_NAME" {
                visibility = if (currentIndex + 1 == props.titles.size) Visibility.hidden else Visibility.visible
            }
        }

        title = props.titles[currentIndex]
        prev = location.prevPageQuery()
        next = location.nextPageQuery(props.titles.size - 1)
        state = state(location.getPageQuery())
    }
}

private external interface SwitchableContentProps : PropsWithChildren, PropsWithClassName {
    var index: Int
    var lastIndex: Int
}

private val SwitchableContent = FC<SwitchableContentProps> { props ->
    val navigate = useNavigate()
    val location = useLocation()
    val (currentIndex, prevIndex) = location.let {
        it.getPageQuery() to (it.switcherState?.prev ?: -1)
    }

    useEffect(currentIndex) {
        // Redirect to first page when access out of range
        if (currentIndex !in 0 until props.lastIndex) {
            navigate(
                location.pathname + FIRST_PAGE_QUERY,
                jso { replace = true },
            )
        }
    }

    div {
        css {
            display = if (props.index == currentIndex) Display.block else None.none

            when (prevIndex) {
                -1 -> animationName = None.none
                currentIndex - 1 -> slideInRight()
                currentIndex + 1 -> slideInLeft()
                else -> animationName = None.none
            }
        }

        +props.children
    }
}

private fun state(prev: Int): SwitcherState = jso { this.prev = prev }
