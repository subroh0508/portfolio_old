@file:Suppress("FunctionName")

package components.atoms

import csstype.*
import emotion.styled.styled
import materialcomponents.*
import react.*
import react.dom.html.ReactHTML.a
import react.router.dom.Link as RouterLink

val MAIN_DRAWER_WIDTH = 224.px

external interface MainDrawerProps : PropsWithChildren, PropsWithClassName

val MainDrawer = FC<MainDrawerProps> { props ->
    StyledDrawer {
        +props.children
    }
}

private val StyledDrawer = Drawer.styled { _, _ ->
    position = Position.fixed
    top = 0.px
    left = 0.px
    height = 100.vh
    width = MAIN_DRAWER_WIDTH
    color = NamedColor.white
    backgroundColor = Color("var(--$VAR_COLOR_BACKGROUND)")
    borderColor = rgba(255, 255, 255, 0.12)
}

external interface MainDrawerHeaderProps : PropsWithClassName {
    var title: Array<out String>
}

fun MainDrawerHeaderProps.title(vararg t: String) { title = t }

val MainDrawerHeader = FC<MainDrawerHeaderProps> { props ->
    StyledMainDrawerHeader {
        props.title.forEach { t ->
            StyledMainTypography {
                use(TypographyUse.headline5)
                tag = "span"

                +t
            }
        }
    }
}

private val StyledMainDrawerHeader = DrawerHeader.styled { _, _ ->
    display = Display.flex
    height = 200.px
    marginRight = 8.px
    flexDirection = FlexDirection.column
    justifyContent = JustifyContent.center
    alignItems = AlignItems.flexEnd
}

private val StyledMainTypography = Typography.styled { _, _ ->
    display = Display.block
    fontSize = 22.px
    fontWeight = FontWeight.bold
    margin = Margin(0.px, 0.px)
}

external interface MainDrawerListProps : PropsWithChildren, PropsWithClassName {
    var selectedIndex: Int
}

val MainDrawerLists = FC<MainDrawerListProps> { props ->
    StyledDrawerContent {
        List {
            Children.toArray(props.children).forEachIndexed { i, item ->
                ListItem {
                    key = i.toString()
                    +item
                }
            }
        }
    }
}

external interface MainDrawerListItemProps : PropsWithClassName {
    var title: String
    var to: String
}

val MainDrawerListItem = FC<MainDrawerListItemProps> { props ->
    RouterLink {
        to = props.to

        Ripple {
            StyledListItemTypography {
                use(TypographyUse.headline6)
                tag = "div"

                +props.title
            }
        }
    }
}

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
