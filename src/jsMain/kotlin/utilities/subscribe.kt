package utilities

import androidx.compose.runtime.*
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.ValueObserver

@Composable
fun <T : Any> Value<T>.subscribeAsState(): State<T> {
    val state = remember(this) { mutableStateOf(value) }

    DisposableEffect(this) {
        val observer: ValueObserver<T> = { state.value = it }

        subscribe(observer)

        onDispose {
            unsubscribe(observer)
        }
    }

    return state
}
