@file:Suppress("FunctionName")

package components.templates

import components.atoms.LargeTitle
import components.atoms.Paragraph
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import components.organisms.titles
import org.w3c.dom.HTMLElement
import react.VFC
import react.create
import react.dom.html.ReactHTML.b
import react.dom.html.ReactHTML.br
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.useRef
import utilities.Links
import utilities.ref
import utilities.useCompose

val SpeaksCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Speaks")
    }

    CardFrame {
        div {
            ref { containerRef.current = it }

            SwitchableContents {
                titles("2020", "2019", "2018")

                +Speaks2020
                +Speaks2019
                +Speaks2018
            }
        }
    }
}

private val Speaks2020 = Paragraph.create {
    ul {
        li {
            b { +"スタートアップで開発している（したい）エンジニア対談 #3:" }
            br {}
            +"「スタートアップの修羅場を乗り越えて思ったこと」"
        }
        li {
            b { +"Kotlin愛好会 vol.21: " }
            +"「"; Links("https://speakerdeck.com/subroh0508/haiburitudonareact-nativeapuriwokotlin-mppdetiyotutoliang-kusuru" to "ハイブリッドなReact NativeアプリをKotlin MPPでﾁｮｯﾄ良くする"); +"」"
        }
        li {
            b { +"Webエンジニア勉強会 in VR 第2回" }
            +"「"; Links("https://speakerdeck.com/subroh0508/zhe-jiao-falsezai-zhai-nafalsedetui-sitoqin-wu-suru" to "折角の在宅なので推しと勤務する"); +"」"
        }
        li {
            b { +"高専キャラバン 2020 Day1: " }
            +"「"; Links("http://kosen-magazine.com/kosen-caravan-1/" to "『お仕事』と『推し事』で加速させる高専生的成長戦略"); +"」"
        }
        li {
            b { +"高専キャラバン 2020 Day2: " }
            +"「"; Links("http://kosen-magazine.com/kosen-caravan-2/" to "『お仕事』と『推し事』で加速させる高専生的成長戦略 -前日譚-"); +"」"
        }
        li {
            b { +"Onlineアイマス学会: " }
            +"「"; Links("https://youtu.be/JJ9Sa6PHKCk?t=18603" to "動点Pとの距離を求めよ 〜アイドル・三峰結華の虚部と実部について〜"); +"」"
        }
        li {
            b { +"Kotlin愛好会 vol.23: " }
            +"「"; Links("https://speakerdeck.com/subroh0508/jsfalsebandoruhuairuwotiyotutowan-zhang-tutexue-jian-suru" to "Kotlin/JSのバンドルファイルをちょっと頑張って削減する"); +"」"
        }
        li {
            b { +"ITエンジニア怪談 ～背筋も凍る、ゾッとする話Night～ #3: " }
            br {}
            +"「"; Links("https://speakerdeck.com/subroh0508/oyuan-ida-kanhuarensuzhi-qian-niatupudetosinaidekure" to "お願いだ、カンファレンス直前にアップデートしないでくれ\uD83E\uDD7A"); +"」"
        }
        li {
            b { +"IM@S ENGINEERS ON@IR!!!! 2020: " }
            br {}
            +"「"; Links("https://speakerdeck.com/subroh0508/xiao-niao-santoaidorufalsepasonarukarawo-jian-suo-dekiruwebapuriwo-100-percent-kotlindezuo-ru" to "小鳥さんとアイドルのパーソナルカラーを検索できるWebアプリを100%Kotlinで作る"); +"」"
        }
    }
}

private val Speaks2019 = Paragraph.create {
    ul {
        li {
            b { +"DroidKaigi2019: " }
            +"「"; Links("https://droidkaigi.jp/2019/timetable/70535/" to "Spek2+MockK+JaCoCoでイケてるUnit Test環境を手に入れろ！"); +"」"
        }
        li {
            b { +"オタクがKotlinを追うライトニングトークイベント: " }
            br {}
            +"「"; Links("https://speakerdeck.com/subroh0508/jstoge-dou-sinagarakotlinfalseiketeruwen-fa-woxue-bu" to "Kotlin/JSと格闘しながらKotlinのイケてる文法を学ぶ"); +"」"
        }
        li {
            b { +"アイマスハッカソン2019 in 名古屋: " }
            +"「"; Links("https://speakerdeck.com/subroh0508/otonashi-meets-im-at-sparql" to "Otonashi meets im@sparql"); +"」"
        }
        li {
            b { +"Kotlin愛好会 vol.10: " }
            +"「"; Links("https://speakerdeck.com/subroh0508/kotlindekueriyan-yu-falsekuraiantowozuo-tutahua" to "Kotlinでクエリ言語のクライアントを作った話"); +"」"
        }
        li {
            b { +"IM@S Engineer Talks 2019: " }
            +"「"; Links("https://youtu.be/8oB-JudUejE?t=6375" to "小鳥さんとKotlinを勉強できるサイトを100%Kotlinで作る"); +"」"
        }
        li {
            b { +"Kotlin Fest 2019: " }
            +"「"; Links("https://youtu.be/-QrMI844kH4" to "フロントエンドもKotlinで書きたい！ -WebページをKotlin/JSで作った軌跡-"); +"」"
        }
        li {
            b { +"趣味でそこまでやっちゃうのか！趣味テックLT大会: " }
            br {}
            +"「"; Links("https://type.jp/et/feature/11965/" to "推しとKotlinが勉強できるサイトでWeb力を押し上げている話") ; +"」"
        }
        li {
            b { +"Yumemi.vue #2: " }
            +"「"; Links("https://speakerdeck.com/subroh0508/vue-dot-jsru-men-1keyue-dezi-zuo-falseji-shu-buroguworirisusitahua" to "Vue.js入門1ヶ月で自作の技術ブログをリリースした話"); +"」"
        }
        li {
            b { +"レガシー感謝の日 2019: " }
            br {}
            +"「新機能開発と並行してリファクタをしてみた(ら納期との闘いになった)」"
        }
    }
}

private val Speaks2018 = Paragraph.create {
    ul {
        li {
            b { +"高専カンファレンス in 東京 2018: " }
            br {}
            +"「"; Links("https://www.slideshare.net/subroh_0508/flutter-105984178" to "Flutterで生み出せ圧倒的成果\uD83D\uDCAA -クロスプラットフォーム開発の未来-"); +"」"
        }
    }
}


