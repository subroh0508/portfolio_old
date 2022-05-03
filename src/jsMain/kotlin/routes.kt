import components.templates.*
import csstype.pct
import emotion.react.css
import org.w3c.dom.HTMLElement
import react.VFC
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import react.useRef
import utilities.ref
import utilities.useCompose

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
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            IntroductionNameCard()
                        }

                        div {
                            css { height = 100.pct }
                            ref { containerRef.current = it }
                        }
                    }.create()
                }

                Route {
                    path = "/biography"
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            BiographyCard()
                        }

                        span { ref { containerRef.current = it } }
                    }.create()
                }

                Route {
                    path = "/skill"
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            SkillCard()
                        }

                        span { ref { containerRef.current = it } }
                    }.create()
                }

                Route {
                    path = "/works"
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            WorksCard()
                        }

                        span { ref { containerRef.current = it } }
                    }.create()
                }

                Route {
                    path = "/speaks"
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            SpeaksCard()
                        }

                        span { ref { containerRef.current = it } }
                    }.create()
                }

                Route {
                    path = "/link"
                    element = VFC {
                        val containerRef = useRef<HTMLElement>(null)

                        useCompose(containerRef) {
                            LinksCard()
                        }

                        span { ref { containerRef.current = it } }
                    }.create()
                }
            }
        }
    }
}.create()
