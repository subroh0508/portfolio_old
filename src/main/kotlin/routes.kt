import components.atoms.Footer
import components.templates.*
import react.RBuilder
import react.child
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

fun RBuilder.routing() = browserRouter {
    child(AppFrame) {
        switch {
            route("/", exact = true) { child(IntroductionNameCard) }
            route("biography", exact = true) { child(BiographyCard) }
            route("skill", exact = true) { child(SkillCard) }
            route("works", exact = true) { child(WorksCard) }
            route("speaks", exact = true) { child(SpeaksCard) }
            route("link", exact = true) { child(LinksCard) }
        }
    }
}
