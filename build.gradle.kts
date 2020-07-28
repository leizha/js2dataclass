plugins {
    kotlin("js") version "1.3.72"
}

kotlin.target.browser {
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    testImplementation(kotlin("test-js"))
}
