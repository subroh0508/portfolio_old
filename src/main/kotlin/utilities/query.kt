package utilities

import history.Location
import org.w3c.dom.url.URLSearchParams

const val FIRST_PAGE_QUERY = "?p=0"

fun Location.getPageQuery() = URLSearchParams(search).get("p")?.toIntOrNull() ?: 0
fun Location.nextPageQuery(max: Int) = "?p=${getPageQuery().let { if (max == it) it else it + 1 }}"
fun Location.prevPageQuery() = "?p=${getPageQuery().let { if (it == 0) it else it - 1 }}"
