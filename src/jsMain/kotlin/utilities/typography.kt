package utilities

import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.times

fun getLetterSpacing(
    tracking: Double,
    fontSize: Double,
) = (tracking / (fontSize * 16.0)) * 1.em
