@file:Suppress("FunctionName")

package components.atoms

import csstype.Color
import csstype.FontWeight
import emotion.styled.styled
import materialcomponents.*
import react.FC
import react.PropsWithChildren
import react.PropsWithClassName

external interface ParagraphProps : PropsWithChildren, PropsWithClassName

val Paragraph = FC<ParagraphProps> { props ->
    StyledBody1 {
        use(TypographyUse.body1)
        tag = "p"

        +props.children
    }
}

private val StyledBody1 = Typography.styled { _, _ ->
    fontWeight = FontWeight.normal
    color = Color("var(--$VAR_COLOR_TEXT_SECONDARY_ON_DARK)")
}
