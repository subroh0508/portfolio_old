import components.templates.*
import react.RBuilder
import react.createElement
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

fun RBuilder.routing() = BrowserRouter {
    child(AppFrame) {
        attrs.navItems(
                { attrs.to = "/"; attrs.title = "Home" },
                { attrs.to = "/biography"; attrs.title= "Biography" },
                { attrs.to = "/skill"; attrs.title= "Skill" },
                { attrs.to = "/works?p=0"; attrs.title= "Works" },
                { attrs.to = "/speaks?p=0"; attrs.title= "Speaks" },
                { attrs.to = "/link"; attrs.title= "Link" }
        )

        Routes {
            Route {
                attrs {
                    path = "/"
                    element = createElement(IntroductionNameCard)
                }
            }

            Route {
                attrs {
                    path = "/biography"
                    element = createElement(BiographyCard)
                }
            }

            Route {
                attrs {
                    path = "/skill"
                    element = createElement(SkillCard)
                }
            }

            Route {
                attrs {
                    path = "/works"
                    element = createElement(WorksCard)
                }
            }

            Route {
                attrs {
                    path = "/speaks"
                    element = createElement(SpeaksCard)
                }
            }

            Route {
                attrs {
                    path = "/link"
                    element = createElement(LinksCard)
                }
            }
        }
    }
}
