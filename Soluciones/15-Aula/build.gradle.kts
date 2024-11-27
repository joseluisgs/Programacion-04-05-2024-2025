plugins {
    kotlin("jvm") version "2.0.21"
    id("org.jetbrains.dokka") version "1.9.20"
}

group = "dev.joseluisgs"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Librerías para Logging
    implementation("org.lighthousegames:logging:1.5.0") // Librería de Logging
    implementation("ch.qos.logback:logback-classic:1.5.12") // Implementación de Logback

    // Mordant
    implementation("com.github.ajalt.mordant:mordant:2.2.0")
    implementation("net.java.dev.jna:jna:5.13.0")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}

// Jar con todas las dependencias
// Jar
tasks.jar {
    manifest {
        attributes["Main-Class"] = "dev.joseluisgs.MainKt"
    }
    // Copia de las librerías a la carpeta lib
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    archiveFileName.set("gestion-aula.jar")
}
