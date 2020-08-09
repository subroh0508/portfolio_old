package utilities

import kotlinext.js.jsObject
import react.RBuilder
import react.RHandler
import react.RProps
import react.router.dom.LinkComponent
import react.router.dom.RouteResultHistory
import react.router.dom.RouteResultLocation

inline fun <T> RouteResultHistory.replace(linkTo: LinkTo<T>) = asDynamic().replace(linkTo)

external interface LinkTo<T> {
    var pathname: String?
    var search: String?
    var hash: String?
    var state: T?
}

val RouteResultLocation.state: dynamic get() = asDynamic()["state"]

fun <T: Any> linkTo(
        pathname: String,
        search: String? = null,
        hash: String? = null,
        state: T = jsObject()
): LinkTo<T> = jsObject {
    this.pathname = pathname
    this.search = search
    this.hash = hash
    this.state = state
}

fun <T> RBuilder.routeLink(
        to: LinkTo<T>,
        replace: Boolean = false,
        className: String? = null,
        handler: RHandler<RProps>?
) = child(LinkComponent::class) {
    attrs {
        this.asDynamic()["to"] = to
        this.replace = replace
        this.className = className
    }
    handler?.invoke(this)
}
