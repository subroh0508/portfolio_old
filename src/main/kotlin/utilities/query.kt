package utilities

import org.w3c.dom.url.URLSearchParams
import react.router.dom.RouteResultLocation

fun RouteResultLocation.getPageQuery() = URLSearchParams(search).get("p")?.toIntOrNull() ?: 0
fun RouteResultLocation.nextPageQuery() = "?p=${getPageQuery() + 1}"
fun RouteResultLocation.prevPageQuery() = "?p=${getPageQuery().let { if (it == 0) it else it - 1 }}"
