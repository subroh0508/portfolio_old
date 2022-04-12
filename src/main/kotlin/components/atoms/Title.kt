@file:Suppress("FunctionName")

package components.atoms

import csstype.Color
import csstype.FontWeight
import emotion.react.css
import emotion.styled.styled
import materialcomponents.*
import react.PropsWithClassName
import react.FC

external interface TitleProps : PropsWithClassName {
    var title: String
    var tag: String?
}

external interface SubtitleProps : PropsWithClassName {
    var subtitle: String
    var tag: String?
}

val LargeTitle = FC<TitleProps> { props ->
    StyledTypographyHeadline4 {
        css(props.className) {}
        use(TypographyUse.headline4)
        tag = props.tag ?: "h2"

        +props.title
    }
}

val LargeSubtitle = FC<SubtitleProps> { props ->
    StyledTypographyHeadline5 {
        css(props.className) {}
        use(TypographyUse.headline5)
        tag = props.tag ?: "h3"

        +props.subtitle
    }
}

val Subtitle = FC<SubtitleProps> { props ->
    StyledTypographyHeadline6 {
        css(props.className) {}
        use(TypographyUse.headline6)
        tag = props.tag ?: "h4"

        +props.subtitle
    }
}

private val StyledTypographyHeadline4 = Typography.styled { _, _ ->
    fontWeight = FontWeight.bold
    color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
}

private val StyledTypographyHeadline5 = Typography.styled { _, _ ->
    color = Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)")
}

private val StyledTypographyHeadline6 = Typography.styled { _, _ ->
    fontWeight = FontWeight.normal
    color = Color("var(--$VAR_COLOR_TEXT_PRIMARY_ON_DARK)")
}
