plugins {
    kotlin("jvm") version "1.9.21"
    application
    // dokka
    id("org.jetbrains.dokka") version "1.9.10"
}

group = "dev.joseluisgs"
version = ""

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "MainKt"
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    configurations["compileClasspath"].forEach { file ->
        from(zipTree(file.absoluteFile))
    }
    archiveFileName.set("starwars.jar")
}