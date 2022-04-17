@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.atoms.Subtitle
import components.organisms.CardFrame
import csstype.Display
import csstype.pct
import emotion.react.css
import org.w3c.dom.HTMLElement
import react.VFC
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.useRef
import utilities.Links
import utilities.ref
import utilities.useCompose

val LinksCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Link")
    }

    CardFrame {
        div {
            ref { containerRef.current = it }

            div {
                css {
                    display = Display.flex
                }

                +OtherPortfolio
                +SocialTipping
            }
        }
    }
}

private val OtherPortfolio = div.create {
    css { width = 50.pct }

    div { +"各種ポートフォリオ・SNS" }
    // TODO Replace Subtitle
    // Subtitle { subtitle = "各種ポートフォリオ・SNS" }

    Paragraph {
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

private val SocialTipping = div.create {
    css { width = 50.pct }

    div { +"何かめぐんでください＞＜" }
    // TODO Replace Subtitle
    // Subtitle { subtitle = "何かめぐんでください＞＜" }

    Paragraph {
        ul {
            li {
                Links("https://www.amazon.jp/hz/wishlist/ls/34TBOXPWOUD8W" to "欲しいものリスト")
            }
        }
    }
}
