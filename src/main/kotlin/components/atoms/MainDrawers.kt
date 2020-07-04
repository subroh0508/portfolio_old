@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import materialcomponents.*
import react.RBuilder
import react.dom.WithClassName
import react.functionalComponent
import styled.StyledHandler
import styled.css
import styled.styled

val MainDrawer = functionalComponent<WithClassName> { props ->
    StyledDrawer(props.className) { props.children() }
}

private fun RBuilder.StyledDrawer(className: String? = null, handler: StyledHandler<DrawerProps>) = (styled(Drawer)) {
    css {
        className?.let(classes::add)
        color = Color.white
        backgroundColor = Color(VAR_COLOR_BACKGROUND.toCustomProperty())
        borderColor = Color.white.withAlpha(0.12)
    }

    handler()
}

external interface MainDrawerHeaderProps : WithClassName {
    var title: Array<out String>
}

fun MainDrawerHeaderProps.title(vararg t: String) { title = t }

val MainDrawerHeader = functionalComponent<MainDrawerHeaderProps> { props ->
    StyledMainDrawerHeader(props.className) {
        props.title.forEach { t -> StyledMainTypography { +t }  }
    }
}

private fun RBuilder.StyledMainDrawerHeader(className: String?, handler: StyledHandler<WithClassName>) = (styled(DrawerHeader)) {
    css {
        className?.let(classes::add)
        display = Display.flex
        flexDirection = FlexDirection.column
        justifyContent = JustifyContent.center
        alignItems = Align.center
        height = 200.px
    }

    handler()
}

private fun RBuilder.StyledMainTypography(handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        display = Display.block
        fontWeight = FontWeight.bold
        margin(0.px)
    }

    attrs.use(TypographyUse.headline5)
    attrs.tag = "span"

    handler()
}

external class MainDrawerListItem {
    var display: String
    var href: String
}

external interface MainDrawerListProps : WithClassName {
    var items: Array<MainDrawerListItem>
    var selectedIndex: Int
}

val MainDrawerLists = functionalComponent<MainDrawerListProps> { props ->
    DrawerContent {
        List {
            props.items.forEach { item -> StyledDrawerListItem { +item.display } }
        }
    }
}

fun RBuilder.StyledDrawerListItem(handler: StyledHandler<ListItemProps>) = (styled(ListItem)) {
    css {

    }

    handler()
}
