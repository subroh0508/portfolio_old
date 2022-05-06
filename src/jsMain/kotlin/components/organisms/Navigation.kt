@file:Suppress("FunctionName")

package components.organisms

import androidx.compose.runtime.Composable
import components.atoms.*

@Composable
fun Navigation(
    vararg title: String,
    menu: @Composable () -> Unit,
) = MainDrawer {
    MainDrawerHeader(*title)
    MainDrawerContent(menu)
}
