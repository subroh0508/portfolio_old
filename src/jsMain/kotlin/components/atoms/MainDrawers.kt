@file:Suppress("FunctionName")

package components.atoms

import androidx.compose.runtime.Composable
import com.arkivanov.essenty.parcelable.Parcelable
import materialcomponents.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*

@Composable
fun MainDrawer(content: @Composable () -> Unit) {
    Style(MainDrawerStyle)

    Aside({ classes(MainDrawerStyle.container) }) { content() }
}

@Composable
fun MainDrawerHeader(content: @Composable () -> Unit) = Div({
    classes(MainDrawerStyle.header)
}) { content() }

@Composable
fun MainDrawerContent(content: @Composable () -> Unit) = Div({
    classes(MainDrawerStyle.content)
}) { Ul { content() } }

@Composable
fun <T: Parcelable> MainDrawerListItems(
    items: List<T>,
    content: (T) -> Pair<String, String>,
) = items.forEach { item ->
    val (href, label) = content(item)

    Li { A(href) { Text(label) } }
}

private object MainDrawerStyle : StyleSheet() {
    val container by style {
        property("z-index", "6")
        display(DisplayStyle.Flex)
        flexDirection(FlexDirection.Column)
        flexShrink(0)

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
        minHeight(64.px)
        padding(0.px, 16.px, 4.px)

        display(DisplayStyle.Flex)
        height(200.px)
        marginRight(8.px)
        flexDirection(FlexDirection.Column)
        justifyContent(JustifyContent.Center)
        alignItems(AlignItems.FlexEnd)
    }

    val content by style {

    }
}

/*
private val StyledDrawerContent = DrawerContent.styled { _, _ ->
    ".mdc-list-item" {
        height = 56.px
        margin = Margin(0.px, 0.px)
        padding = Padding(0.px, 0.px)
        textAlign = TextAlign.end
    }

    ".mdc-ripple-surface" {
        before {
            backgroundColor = NamedColor.white
        }

        after {
            backgroundColor = NamedColor.white
        }
    }

    a {
        display = Display.flex
        width = 100.pct
        color = NamedColor.white
        textDecoration = None.none
    }
}

private val StyledListItemTypography = Typography.styled { _, _ ->
    width = 100.pct
    padding = Padding(12.px, 8.px)
    paddingRight = 24.px
    borderRadius = 0.5.rem
    fontWeight = FontWeight.normal
}
*/
