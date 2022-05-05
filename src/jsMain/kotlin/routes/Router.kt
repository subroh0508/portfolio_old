package routes

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.navigate
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.router.webhistory.DefaultWebHistoryController
import com.arkivanov.decompose.router.webhistory.WebHistoryController

@OptIn(ExperimentalDecomposeApi::class)
class Router(
    context: ComponentContext,
    pathname: String? = null,
    query: String? = null,
    webHistoryController: WebHistoryController = DefaultWebHistoryController(),
) : ComponentContext by context {
    private val router = context.router(
        initialStack = { listOf(pathname?.let { Page(it, query) } ?: Page.Introduction) },
        handleBackButton = true,
        key = "router",
    ) { page, _ -> page }

    init {
        webHistoryController.attach(
            router,
            getPath = { it.path },
            getConfiguration = Page::invoke,
        )
    }

    val routerState = router.state

    fun toWorks(index: Int) { push(Page.Works(index)) }
    fun toSpeaks(index: Int) { push(Page.Speaks(index)) }

    fun push(page: Page) {
        if (routerState.value.activeChild.configuration == page) {
            return
        }

        router.navigate { it.filterNot { p -> p == page } + page }
    }
}
