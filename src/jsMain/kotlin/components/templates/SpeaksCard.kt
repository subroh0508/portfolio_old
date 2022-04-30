@file:Suppress("FunctionName")

package components.templates

import androidx.compose.runtime.Composable
import components.atoms.ComposableParagraph
import components.atoms.LargeTitle
import components.atoms.Link
import components.organisms.CardFrame
import components.organisms.SwitchableContents
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLElement
import react.VFC
import react.dom.html.ReactHTML.div
import react.useRef
import utilities.ref
import utilities.useCompose

val SpeaksCard = VFC {
    val containerRef = useRef<HTMLElement>(null)

    useCompose(containerRef) {
        LargeTitle(text = "Speaks")

        SwitchableContents(
            listOf("2020", "2019", "2018"),
            { Speaks2020() },
            { Speaks2019() },
            { Speaks2018() },
        )
    }

    CardFrame {
        div {
            ref { containerRef.current = it }
        }
    }
}

@Composable
private fun Speaks2020() = ComposableParagraph {
    Ul {
        Li {
            B { Text("スタートアップで開発している（したい）エンジニア対談 #3:" ) }
            Br {  }
            Text("「スタートアップの修羅場を乗り越えて思ったこと」")
        }
        Li {
            B { Text("Kotlin愛好会 vol.21: ") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/haiburitudonareact-nativeapuriwokotlin-mppdetiyotutoliang-kusuru" to "ハイブリッドなReact NativeアプリをKotlin MPPでﾁｮｯﾄ良くする")
            Text("」")
        }
        Li {
            B { Text("Webエンジニア勉強会 in VR 第2回") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/zhe-jiao-falsezai-zhai-nafalsedetui-sitoqin-wu-suru" to "折角の在宅なので推しと勤務する")
            Text("」")
        }
        Li {
            B { Text("高専キャラバン 2020 Day1: ") }
            Text("「")
            Link("http://kosen-magazine.com/kosen-caravan-1/" to "『お仕事』と『推し事』で加速させる高専生的成長戦略")
            Text("」")
        }
        Li {
            B { Text("高専キャラバン 2020 Day2: ") }
            Text("「")
            Link("http://kosen-magazine.com/kosen-caravan-2/" to "『お仕事』と『推し事』で加速させる高専生的成長戦略 -前日譚-")
            Text("」")
        }
        Li {
            B { Text("Onlineアイマス学会: ") }
            Text("「")
            Link("https://youtu.be/JJ9Sa6PHKCk?t=18603" to "動点Pとの距離を求めよ 〜アイドル・三峰結華の虚部と実部について〜")
            Text("」")
        }
        Li {
            B { Text("Kotlin愛好会 vol.23: ") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/jsfalsebandoruhuairuwotiyotutowan-zhang-tutexue-jian-suru" to "Kotlin/JSのバンドルファイルをちょっと頑張って削減する")
            Text("」")
        }
        Li {
            B { Text("ITエンジニア怪談 ～背筋も凍る、ゾッとする話Night～ #3: ") }
            Br {}
            Text("「")
            Link("https://speakerdeck.com/subroh0508/oyuan-ida-kanhuarensuzhi-qian-niatupudetosinaidekure" to "お願いだ、カンファレンス直前にアップデートしないでくれ\uD83E\uDD7A")
            Text("」")
        }
        Li {
            B { Text("IM@S ENGINEERS ON@IR!!!! 2020: ") }
            Br {}
            Text("「")
            Link("https://speakerdeck.com/subroh0508/xiao-niao-santoaidorufalsepasonarukarawo-jian-suo-dekiruwebapuriwo-100-percent-kotlindezuo-ru" to "小鳥さんとアイドルのパーソナルカラーを検索できるWebアプリを100%Kotlinで作る")
            Text("」")
        }
    }
}

@Composable
private fun Speaks2019() = ComposableParagraph {
    Ul {
        Li {
            B { Text("DroidKaigi2019: ") }
            Text("「")
            Link("https://droidkaigi.jp/2019/timetable/70535/" to "Spek2+MockK+JaCoCoでイケてるUnit Test環境を手に入れろ！")
            Text("」")
        }
        Li {
            B { Text("オタクがKotlinを追うライトニングトークイベント: ") }
            Br {}
            Text("「")
            Link("https://speakerdeck.com/subroh0508/jstoge-dou-sinagarakotlinfalseiketeruwen-fa-woxue-bu" to "Kotlin/JSと格闘しながらKotlinのイケてる文法を学ぶ")
            Text("」")
        }
        Li {
            B { Text("アイマスハッカソン2019 in 名古屋: ") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/otonashi-meets-im-at-sparql" to "Otonashi meets im@sparql")
            Text("」")
        }
        Li {
            B { Text("Kotlin愛好会 vol.10: ") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/kotlindekueriyan-yu-falsekuraiantowozuo-tutahua" to "Kotlinでクエリ言語のクライアントを作った話")
            Text("」")
        }
        Li {
            B { Text("IM@S Engineer Talks 2019: ") }
            Text("「")
            Link("https://youtu.be/8oB-JudUejE?t=6375" to "小鳥さんとKotlinを勉強できるサイトを100%Kotlinで作る")
            Text("」")
        }
        Li {
            B { Text("Kotlin Fest 2019: ") }
            Text("「")
            Link("https://youtu.be/-QrMI844kH4" to "フロントエンドもKotlinで書きたい！ -WebページをKotlin/JSで作った軌跡-")
            Text("」")
        }
        Li {
            B { Text("趣味でそこまでやっちゃうのか！趣味テックLT大会: ") }
            Br {}
            Text("「")
            Link("https://type.jp/et/feature/11965/" to "推しとKotlinが勉強できるサイトでWeb力を押し上げている話")
            Text("」")
        }
        Li {
            B { Text("Yumemi.vue #2: ") }
            Text("「")
            Link("https://speakerdeck.com/subroh0508/vue-dot-jsru-men-1keyue-dezi-zuo-falseji-shu-buroguworirisusitahua" to "Vue.js入門1ヶ月で自作の技術ブログをリリースした話")
            Text("」")
        }
        Li {
            B { Text("レガシー感謝の日 2019: ") }
            Br {}
            Text("「新機能開発と並行してリファクタをしてみた(ら納期との闘いになった)」")
        }
    }
}

@Composable
private fun Speaks2018() = ComposableParagraph {
    Ul {
        Li {
            B { Text("高専カンファレンス in 東京 2018: ") }
            Br {}
            Text("「")
            Link("https://www.slideshare.net/subroh_0508/flutter-105984178" to "Flutterで生み出せ圧倒的成果\uD83D\uDCAA -クロスプラットフォーム開発の未来-")
            Text("」")
        }
    }
}


