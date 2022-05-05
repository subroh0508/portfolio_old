@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import com.arkivanov.essenty.parcelable.Parcelable
import externals.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun MainDrawer(content: @Composable () -> Unit) {
    Style(MainDrawerStyle)

    Aside({ classes(MainDrawerStyle.container, "mdc-drawer") }) { content() }
}

@Composable
fun MainDrawerHeader(vararg title: String) = Div({
    classes(MainDrawerStyle.header, "mdc-drawer__header")
}) {
    title.forEach {
        Span({ classes("mdc-typography--headline5") }) { Text(it) }
    }
}

@Composable
fun MainDrawerContent(content: @Composable () -> Unit) = Div({
    classes(MainDrawerStyle.content, "mdc-drawer__content")
}) {
    Ul({ classes("mdc-list") }) { content() }
}

@Composable
fun <T: Parcelable> MainDrawerListItems(
    items: List<T>,
    content: (T) -> Pair<String, String>,
) = items.forEach { item ->
    val (href, label) = content(item)

    Li({ classes("mdc-list-item") }) {
        A(href) {
            Ripple({ classes("mdc-typography--headline6") }) {
                Text(label)
            }
        }
    }
}

private object MainDrawerStyle : StyleSheet() {
    val container by style {
        position(Position.Fixed)
        top(0.px)
        left(0.px)
        height(100.vh)
        width(224.px)
        color(Color.white)
        backgroundColor(Color("var(--$VAR_COLOR_BACKGROUND)"))
        border {
            style(LineStyle.Solid)
            color(rgba(255, 255, 255, 0.12))
        }
        borderWidth(0.px, 1.px, 0.px, 0.px)
    }

    val header by style {
        display(DisplayStyle.Flex)
        height(200.px)
        marginRight(8.px)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.FlexEnd)

        className("mdc-typography--headline5") style {
            display(DisplayStyle.Block)
            fontSize(22.px)
            fontWeight("bold")
            margin(0.px)
        }
    }

    val content by style {
        className("mdc-list-item") style {
            height(56.px)
            margin(0.px)
            padding(0.px)
            textAlign("end")
        }

        type("a") style {
            display(DisplayStyle.Flex)
            width(100.percent)
            color(Color.white)
            textDecoration("none")
        }

        className("mdc-typography--headline6") style {
            width(100.percent)
            padding(12.px, 8.px)
            paddingRight(24.px)
            borderRadius(0.5.cssRem)
            fontWeight("normal")
        }
    }
}
