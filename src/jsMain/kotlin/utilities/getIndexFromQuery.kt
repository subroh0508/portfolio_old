package utilities

import androidx.compose.runtime.*

@Composable
fun getIndex(index: Int, max: Int, fallback: () -> Unit): State<Int> {
    val current = remember(index) { mutableStateOf(index) }

    SideEffect {
        if (current.value in 0 until max) {
            return@SideEffect
        }

        current.value = 0
        fallback()
    }

    return current
}
