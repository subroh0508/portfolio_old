@file:Suppress("FunctionName")

package components.organisms

import components.molecules.CHEVRON_LEFT_CLASS_NAME
import components.molecules.CHEVRON_RIGHT_CLASS_NAME
import components.molecules.Switcher
import kotlinx.css.Display
import kotlinx.css.Visibility
import kotlinx.css.display
import kotlinx.css.visibility
import org.w3c.dom.events.Event
import react.*
import react.dom.WithClassName
import styled.css
import styled.styledDiv
import utilities.styled

external interface SwitchableContentsProps : WithClassName {
    var titles: Array<out String>
}

fun SwitchableContentsProps.titles(vararg title: String) { titles = title }

val SwitchableContents = functionalComponent<SwitchableContentsProps> { props ->
    val (index, setIndex) = useState(0)
    // val index = props.titles.indexOf("kotlin-material-ui").takeIf { it != -1 } ?: 0

    StyledSwitcher(index, props.titles, setIndex)

    Children.toArray(props.children).forEachIndexed { i, child ->
        styledDiv {
            css { display = if (i == index) Display.block else Display.none }

            child(child)
        }
    }
}

private fun RBuilder.StyledSwitcher(
        index: Int,
        titles: Array<out String>,
        setIndex: (Int) -> Unit
) = (styled(Switcher)) {
    css {
        descendants(".$CHEVRON_LEFT_CLASS_NAME") {
            visibility = if (index == 0) Visibility.hidden else Visibility.visible
        }
        descendants(".$CHEVRON_RIGHT_CLASS_NAME") {
            visibility = if (index + 1 == titles.size) Visibility.hidden else Visibility.visible
        }
    }

    attrs.title = titles[index]
    attrs.onClickedLeft = { setIndex(index - 1) }
    attrs.onClickedRight = { setIndex(index + 1) }
}


