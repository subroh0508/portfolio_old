package components.biography.profiles

import components.biography.maps.googleMap
import materialui.components.typography.enums.TypographyVariant
import materialui.components.typography.typography
import react.RBuilder
import react.dom.a
import react.dom.div
import react.dom.li
import react.dom.ul
import styles.fromStyle

fun RBuilder.from(handler: ProfileProps.() -> Unit) = profile {
    attrs.classNamePrefix = "from"
    attrs.title { +"From: 伊豆大島" }

    attrs.cardContent("From", fromStyle) { props: FromProps ->
        div(props.paragraphStyle) {
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                +"　さぶろ〜の地元。東京湾から南に100km泳ぐと現れる離島。活火山・三原山とキレイな海が自慢。それ以外のモノはあんまりない。"
            }
            typography(p = true) {
                attrs.variant = TypographyVariant.h6

                +"　順調に人口が減り続けておりぶっちゃけヤバイので、観光に来てくれると泣いて喜ぶ😭"
            }
            div { +"観光情報" }
            ul {
                li {
                    a { attrs.href = "http://www.izu-oshima.or.jp/"; attrs.target = "_blank"; +"伊豆大島観光協会" }
                }
                li {
                    a { attrs.href = "https://oshima-navi.com/"; attrs.target = "_blank"; +"伊豆大島の楽しみ方発見サイト『伊豆大島ナビ』" }
                }
                li {
                    a { attrs.href = "https://www.tokaikisen.co.jp/island/oshima/"; attrs.target = "_blank"; +"伊豆諸島 大島のおすすめ観光スポット｜東海汽船" }
                }
            }
        }

        div(props.googleMapStyle) {
            googleMap {  }
        }
    }

    attrs.handler()
}