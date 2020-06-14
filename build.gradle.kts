buildscript {
    repositories {
        google()
        jcenter()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }

    dependencies {
        classpath(Libraries.Plugins.kotlinGradle)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
        maven(url = "http://dl.bintray.com/kotlin/kotlin-js-wrappers")
        maven(url = "https://dl.bintray.com/subroh0508/maven")
    }
}
