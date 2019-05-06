plugins {
    id("kotlin2js") version "1.3.31"
}

group = "net.subroh0508"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
}
