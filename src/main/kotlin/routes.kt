import components.templates.*
import react.ChildrenBuilder
import react.createElement
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

fun ChildrenBuilder.routing() = BrowserRouter {
    AppFrame {
        navItems(
                { attrs.to = "/"; attrs.title = "Home" },
                { attrs.to = "/biography"; attrs.title= "Biography" },
                { attrs.to = "/skill"; attrs.title= "Skill" },
                { attrs.to = "/works?p=0"; attrs.title= "Works" },
                { attrs.to = "/speaks?p=0"; attrs.title= "Speaks" },
                { attrs.to = "/link"; attrs.title= "Link" }
        )

        Routes {
            Route {
                path = "/"
                element = createElement(IntroductionNameCard)
            }

            Route {
                path = "/biography"
                element = createElement(BiographyCard)
            }

            Route {
                path = "/skill"
                element = createElement(SkillCard)
            }

            Route {
                path = "/works"
                element = createElement(WorksCard)
            }

            Route {
                path = "/speaks"
                element = createElement(SpeaksCard)
            }

            Route {
                path = "/link"
                element = createElement(LinksCard)
            }
        }
    }
}
