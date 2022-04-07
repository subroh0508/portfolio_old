import components.templates.*
import react.RBuilder
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
                    caseSensitive = true
                }

                child(IntroductionNameCard)
            }

            Route {
                attrs {
                    path = "/biography"
                    caseSensitive = true
                }

                child(BiographyCard)
            }

            Route {
                attrs {
                    path = "/skill"
                    caseSensitive = true
                }

                child(SkillCard)
            }

            Route {
                attrs {
                    path = "/speaks"
                    caseSensitive = true
                }

                child(SpeaksCard)
            }

            Route {
                attrs {
                    path = "/link"
                    caseSensitive = true
                }

                child(LinksCard)
            }
        }
    }
}
