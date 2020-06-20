package utilities

import react.FunctionalComponent
import react.RBuilder
import react.ReactElement
import react.dom.WithClassName
import styled.StyledElementBuilder
import styled.StyledHandler

fun <P : WithClassName> styled(functionalComponent: FunctionalComponent<P>): RBuilder.(StyledHandler<P>) -> ReactElement = { handler ->
    child(with(StyledElementBuilder<P>(functionalComponent)) {
        handler()
        create()
    })
}
