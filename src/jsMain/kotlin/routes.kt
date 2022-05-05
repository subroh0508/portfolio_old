import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import components.atoms.MainDrawerListItems
import components.templates.*
import routes.Page
import routes.Router
import utilities.subscribeAsState

@Composable
fun Routing(
    router: Router,
) {
    val routerState by router.routerState.subscribeAsState()

    AppFrame(
        menu = {
            MainDrawerListItems(
                Page.forMenu(),
            ) {
                when (it) {
                    is Page.Introduction -> "/" to "Home"
                    is Page.Biography -> "/biography" to "Biography"
                    is Page.Skill -> "/skill" to "Skill"
                    is Page.Works -> "/works?p=0" to "Works"
                    is Page.Speaks -> "/speaks?p=0" to "Speaks"
                    is Page.Link -> "/link" to "Link"
                }
            }
        }
    ) {
        when (routerState.activeChild.instance) {
            is Page.Introduction -> IntroductionNameCard()
            is Page.Biography -> BiographyCard()
            is Page.Skill -> SkillCard()
            is Page.Works -> WorksCard()
            is Page.Speaks -> SpeaksCard()
            is Page.Link -> LinksCard()
        }
    }
}
