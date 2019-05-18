package components.header

import kotlinx.css.px
import materialui.components.appbar.appBar
import materialui.components.appbar.enums.AppBarColor
import materialui.components.appbar.enums.AppBarStyle
import materialui.components.tab.tab
import materialui.components.tabs.enums.TabsIndicatorColor
import materialui.components.tabs.enums.TabsStyle
import materialui.components.tabs.tabs
import materialui.components.toolbar.enums.ToolbarStyle
import materialui.components.toolbar.toolbar
import materialui.components.typography.enums.TypographyColor
import materialui.components.typography.enums.TypographyStyle
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.RComponent
import react.dom.div
import react.setState
import reactswipableviews.onChangeIndex
import reactswipableviews.swipeableViews

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

                toolbar(ToolbarStyle.root to props.toolbar) {
                    typography(TypographyStyle.root to props.title) {
                        attrs.variant = TypographyVariant.h5
                        attrs.color = TypographyColor.inherit

                        +"Subroh Nishikori's Portfolio"
                    }

                    div(props.subtitle) {
                        +"Admiral, Idol Producer, and Application Developer"
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
                        attrs.disableRipple = true
                        attrs.label { +"biography" }
                    }
                    tab {
                        attrs.disableRipple = true
                        attrs.label { +"works" }
                    }
                    tab {
                        attrs.disableRipple = true
                        attrs.label { +"links" }
                    }
                }
            }

            div(props.contents) {
                swipeableViews {
                    attrs.index = state.tabNumber
                    attrs.onChangeIndex { index -> onChangeTab(index) }

                    props.views.forEach { view -> child(view) }
                }
            }
        }
    }
}
