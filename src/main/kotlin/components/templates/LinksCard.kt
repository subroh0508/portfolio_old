@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.atoms.Subtitle
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import components.organisms.titles
import kotlinx.css.Display
import kotlinx.css.display
import kotlinx.css.pct
import kotlinx.css.width
import react.RBuilder
import react.child
import react.dom.*
import react.functionalComponent
import styled.css
import styled.styledDiv
import utilities.Links

val LinksCard = functionalComponent<WithClassName> {
    child(CardFrame) {
        child(LargeTitle) {
            attrs.title = "Link"
        }

        styledDiv {
            css {
                display = Display.flex
            }

            OtherPortfolio()
            SocialTipping()
        }
    }
}

private fun RBuilder.OtherPortfolio() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "各種ポートフォリオ・SNS" }

    child(Paragraph) {
        ul {
            li {
                Links("https://lapras.com/public/6DDUK2W" to "LAPRAS")
            }
            li {
                Links("https://connpass.com/user/subroh_0508/" to "connpass")
            }
            li {
                Links("https://www.wantedly.com/users/18284613" to "Wantedly")
            }
            li {
                Links("https://www.linkedin.com/in/subroh0508/" to "LinkedIn")
            }
            li {
                Links("https://portfolio.forkwell.com/@subroh_0508" to "forkwell")
            }
            li {
                Links("https://youtrust.jp/users/bf4d03404421536118399a440444aa93" to "YOUTRUST")
            }
        }
    }
}

private fun RBuilder.SocialTipping() = styledDiv {
    css { width = 50.pct }

    child(Subtitle) { attrs.subtitle = "何かめぐんでください＞＜" }


    child(Paragraph) {
        ul {
            li {
                Links("https://www.amazon.jp/hz/wishlist/ls/34TBOXPWOUD8W" to "欲しいものリスト")
            }
        }
    }
}
