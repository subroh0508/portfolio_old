import components.templates.*
import react.RBuilder
import react.child
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.routing() = browserRouter {
    child(AppFrame) {
        attrs.navItems(
                { attrs.to = "/"; attrs.title = "Home" },
                { attrs.to = "/biography"; attrs.title= "Biography" },
                { attrs.to = "/skill"; attrs.title= "Skill" },
                { attrs.to = "/works"; attrs.title= "Works" },
                { attrs.to = "/speaks"; attrs.title= "Speaks" },
                { attrs.to = "/link"; attrs.title= "Link" }
        )

        switch {
            route("/", exact = true) { child(IntroductionNameCard) }
            route("/biography", exact = true) { child(BiographyCard) }
            route("/skill", exact = true) { child(SkillCard) }
            route("/works", exact = true) { child(WorksCard) }
            route("/speaks", exact = true) { child(SpeaksCard) }
            route("/link", exact = true) { child(LinksCard) }
        }
    }
}
