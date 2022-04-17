package utilities

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.HTMLElement
import react.*

inline fun Props.ref(noinline block: (HTMLElement?) -> Unit) {
    asDynamic()["ref"] = block
}

fun useCompose(
    containerRef: MutableRefObject<HTMLElement>,
    composable: @Composable () -> Unit,
) {
    useLayoutEffect {
        val composition = renderComposable(containerRef.current!!) {
            composable()
        }

        cleanup {
            composition.dispose()
        }
    }
}

fun <T> useCompose(
        containerRef: MutableRefObject<HTMLElement>,
        stateInitialValue: T,
        stateValueProvider: () -> T,
        composable: @Composable (state: State<T>) -> Unit,
) {
    val mutableState = useRef(mutableStateOf(stateInitialValue))

    useEffect {
        mutableState.current?.value = stateValueProvider()
    }

    useLayoutEffect {
        val composition = renderComposable(containerRef.current!!) {
            composable(mutableState.current!!)
        }

        cleanup {
            composition.dispose()
        }
    }
}
