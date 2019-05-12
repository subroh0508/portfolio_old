package components.header

import kotlinx.css.px
import materialui.components.appbar.appBar
import materialui.components.appbar.enums.AppBarColor
import materialui.components.appbar.enums.AppBarStyle
import materialui.components.tab.tab
import materialui.components.tabs.enums.TabsIndicatorColor
import materialui.components.tabs.enums.TabsStyle
import materialui.components.tabs.tabs
import materialui.components.toolbar.toolbar
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState

class AppFrame : RComponent<AppFrameProps, AppFrameState>() {
    override fun AppFrameState.init() {
        tabNumber = 0
    }

    private fun onChangeTab(number: Int) {
        setState { tabNumber = number }
    }

    override fun RBuilder.render() {
        div(props.root) {
            appBar(AppBarStyle.root to props.appBar) {
                attrs.color = AppBarColor.primary

                toolbar {
                    typography {
                        attrs.variant = TypographyVariant.h6
                        attrs.color = TypographyColor.inherit

                        +"Subroh Nishikori's Portfolio"
                    }
                }

                tabs(
                    TabsStyle.flexContainer to props.tabs,
                    TabsStyle.indicator to props.tabsIndicator
                ) {
                    attrs {
                        value = state.tabNumber
                        indicatorColor = TabsIndicatorColor.secondary
                        tabIndicatorProps {
                            style {
                                width = 100.px
                            }
                        }
                        onChange = { _, i -> onChangeTab(i) }
                    }

                    tab {
                        attrs.label { +"biography" }
                    }
                    tab {
                        attrs.label { +"works" }
                    }
                    tab {
                        attrs.label { +"links" }
                    }
                }
            }

            div(props.contents) {
                child(props.views[state.tabNumber])
            }
        }
    }
}
