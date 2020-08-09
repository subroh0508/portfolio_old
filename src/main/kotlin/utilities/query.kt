package utilities

import org.w3c.dom.url.URLSearchParams
import react.router.dom.RouteResultLocation

const val FIRST_PAGE_QUERY = "?p=0"

fun RouteResultLocation.getPageQuery() = URLSearchParams(search).get("p")?.toIntOrNull() ?: 0
fun RouteResultLocation.nextPageQuery(max: Int) = "?p=${getPageQuery().let { if (max == it) it else it + 1 }}"
fun RouteResultLocation.prevPageQuery() = "?p=${getPageQuery().let { if (it == 0) it else it - 1 }}"
