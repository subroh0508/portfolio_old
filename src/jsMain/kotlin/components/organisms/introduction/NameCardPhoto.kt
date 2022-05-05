@file:Suppress("FunctionName")

package components.organisms.introduction

import androidx.compose.runtime.Composable
import externals.VAR_COLOR_SURFACE
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div

@Composable
fun NameCardPhoto(
    photoSrc: String,
) {
    Div({
        style {
            property("margin", "-24px 24px 0 auto")
        }
    }) { Photo(photoSrc) }
}

@Composable
private fun Photo(src: String) {
    Div({
        style {
            height(280.px)
            width(210.px)
            backgroundImage("url($src)")
            backgroundSize("cover")
        }
    }) {
        Div({
            style {
                backgroundImage("radial-gradient(ellipse, transparent 50%, var(--$VAR_COLOR_SURFACE) 72%)")
                height(280.px)
                width(210.px)
            }
        })
    }
}
