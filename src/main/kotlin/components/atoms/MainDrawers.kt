@file:Suppress("FunctionName")

package components.atoms

import kotlinext.js.jsObject
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
    var items: Array<out MainDrawerListItem>
    var selectedIndex: Int
}

fun MainDrawerListProps.items(vararg item: MainDrawerListItem.() -> Unit) { items = item.map(::jsObject).toTypedArray() }

val MainDrawerLists = functionalComponent<MainDrawerListProps> { props ->
    StyledDrawerContent {
        List {
            props.items.forEach { item ->
                StyledDrawerListItem {
                    StyledListItemTypography { +item.display }
                }
            }
        }
    }
}

fun RBuilder.StyledDrawerContent(handler: StyledHandler<WithClassName>) = (styled(DrawerContent)) {
    css {
        descendants(".mdc-list-item") {
            color = Color.white
            fontSize = 20.px
            fontWeight = FontWeight.normal
        }
    }

    handler()
}

fun RBuilder.StyledDrawerListItem(handler: StyledHandler<ListItemProps>) = (styled(ListItem)) {
    css {
        color = Color(VAR_COLOR_TEXT_PRIMARY_ON_DARK.toCustomProperty())
    }

    handler()
}

fun RBuilder.StyledListItemTypography(handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        fontWeight = FontWeight.normal
    }

    attrs.use(TypographyUse.headline6)
    attrs.tag = "h4"

    handler()
}
