repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots")
}

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation("com.github.kepocnhh:GradleExtension.Core:0.6.1-SNAPSHOT")
    implementation("com.github.kepocnhh:Gradlex:0.1.0")
}
