import components.templates.*
import react.VFC
import react.create
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter

val routing = VFC {
    BrowserRouter {
        AppFrame {
            navItems(
                { to = "/"; title = "Home" },
                { to = "/biography"; title = "Biography" },
                { to = "/skill"; title = "Skill" },
                { to = "/works?p=0"; title = "Works" },
                { to = "/speaks?p=0"; title = "Speaks" },
                { to = "/link"; title = "Link" },
            )

            Routes {
                Route {
                    path = "/"
                    element = IntroductionNameCard.create()
                }

                Route {
                    path = "/biography"
                    element = BiographyCard.create()
                }

                Route {
                    path = "/skill"
                    element = SkillCard.create()
                }

                Route {
                    path = "/works"
                    element = WorksCard.create()
                }

                Route {
                    path = "/speaks"
                    element = SpeaksCard.create()
                }

                Route {
                    path = "/link"
                    element = LinksCard.create()
                }
            }
        }
    }
}.create()
