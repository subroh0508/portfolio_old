pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if (requested.id.id == "kotlin2js") {
                useModule(Dep.kotlin)
            }
        }
    }
}
rootProject.name = "portfolio"
