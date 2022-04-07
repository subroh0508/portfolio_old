@file:Suppress("FunctionName")

package components.atoms

import kotlinx.css.*
import kotlinx.css.properties.TextDecoration
import materialcomponents.*
import react.*
import react.router.dom.Link as RouterLink
import styled.StyledHandler
import styled.StyledProps
import styled.css
import styled.styled

val MAIN_DRAWER_WIDTH = 224.px

val MainDrawer = fc<StyledProps> { props ->
    StyledDrawer(props.className.unsafeCast<String>()) { props.children() }
}

private fun RBuilder.StyledDrawer(className: String? = null, handler: StyledHandler<DrawerProps>) = (styled(Drawer)) {
    css {
        className?.let(classes::add)
        position = Position.fixed
        top = 0.px
        left = 0.px
        height = 100.vh
        width = MAIN_DRAWER_WIDTH
        color = Color.white
        backgroundColor = Color(VAR_COLOR_BACKGROUND.toCustomProperty())
        borderColor = Color.white.withAlpha(0.12)
    }

    handler()
}

external interface MainDrawerHeaderProps : StyledProps {
    var title: Array<out String>
}

fun MainDrawerHeaderProps.title(vararg t: String) { title = t }

val MainDrawerHeader = fc<MainDrawerHeaderProps> { props ->
    StyledMainDrawerHeader(props.className.unsafeCast<String>()) {
        props.title.forEach { t -> StyledMainTypography { +t }  }
    }
}

private fun RBuilder.StyledMainDrawerHeader(className: String?, handler: StyledHandler<StyledProps>) = (styled(DrawerHeader)) {
    css {
        className?.let(classes::add)
        display = Display.flex
        height = 200.px
        marginRight = 8.px
        flexDirection = FlexDirection.column
        justifyContent = JustifyContent.center
        alignItems = Align.flexEnd
    }

    handler()
}

private fun RBuilder.StyledMainTypography(handler: StyledHandler<TypographyProps>) = (styled(Typography)) {
    css {
        display = Display.block
        fontSize = 22.px
        fontWeight = FontWeight.bold
        margin(0.px)
    }

    attrs.use(TypographyUse.headline5)
    attrs.tag = "span"

    handler()
}

external interface MainDrawerListProps : StyledProps {
    var selectedIndex: Int
}

val MainDrawerLists = fc<MainDrawerListProps> { props ->
    StyledDrawerContent {
        List {
            Children.toArray(props.children).forEachIndexed { i, item ->
                ListItem {
                    attrs.key = i.toString()
                    child(item)
                }
            }
        }
    }
}

external interface MainDrawerListItemProps : StyledProps {
    var title: String
    var to: String
}

val MainDrawerListItem = fc<MainDrawerListItemProps> { props ->
    RouterLink {
        attrs.to = props.to

        Ripple { StyledListItemTypography { +props.title } }
    }
}

private fun RBuilder.StyledDrawerContent(handler: StyledHandler<StyledProps>) = (styled(DrawerContent)) {
    css {
        descendants(".mdc-list-item") {
            height = 56.px
            margin(0.px)
            padding(0.px)
            textAlign = TextAlign.end
        }

        descendants(".mdc-ripple-surface") {
            before {
                backgroundColor = Color.white
            }

            after {
                backgroundColor = Color.white
            }
        }

        a {
            display = Display.flex
            width = 100.pct
            color = Color.white
            textDecoration = TextDecoration.none
        }
    }

    handler()
}

private fun RBuilder.StyledListItemTypography(handler: RBuilder.() -> Unit) = (styled(Typography)) {
    css {
        width = 100.pct
        padding(12.px, 8.px)
        paddingRight = 24.px
        borderRadius = 0.5.rem
        fontWeight = FontWeight.normal
    }

    attrs.use(TypographyUse.headline6)
    attrs.tag = "div"

    handler()
}


