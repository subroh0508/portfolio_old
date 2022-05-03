@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.*
import components.organisms.CardFrame
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Ul

@Composable
fun LinksCard() = CardFrame {
    Style(LinksCardStyle)

    LargeTitle(text = "Link")

    Div({ classes(LinksCardStyle.content) }) {
        OtherPortfolio()
        SocialTippling()
    }
}

@Composable
private fun OtherPortfolio() {
    Div({
        style {
            width(50.percent)
        }
    }) {
        Subtitle(text = "各種ポートフォリオ・SNS")

        ComposableParagraph {
            Ul {
                Li {
                    Link("https://lapras.com/public/6DDUK2W" to "LAPRAS")
                }
                Li {
                    Link("https://connpass.com/user/subroh_0508/" to "connpass")
                }
                Li {
                    Link("https://www.wantedly.com/users/18284613" to "Wantedly")
                }
                Li {
                    Link("https://www.linkedin.com/in/subroh0508/" to "LinkedIn")
                }
                Li {
                    Link("https://portfolio.forkwell.com/@subroh_0508" to "forkwell")
                }
                Li {
                    Link("https://youtrust.jp/users/bf4d03404421536118399a440444aa93" to "YOUTRUST")
                }
            }
        }
    }
}

@Composable
private fun SocialTippling() {
    Div({
        style {
            width(50.percent)
        }
    }) {
        Subtitle(text = "何かめぐんでください＞＜")

        ComposableParagraph {
            Ul {
                Li {
                    Link("https://www.amazon.jp/hz/wishlist/ls/34TBOXPWOUD8W" to "欲しいものリスト")
                }
            }
        }
    }
}
private object LinksCardStyle : StyleSheet() {
    val content by style {
        display(DisplayStyle.Flex)
    }
}
