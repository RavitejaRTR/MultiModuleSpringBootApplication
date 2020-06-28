buildscript {
    repositories {
        mavenCentral()
    }
}

description = "Spring boot application's application module"

plugins {
    id("org.springframework.boot") version "2.3.0.RELEASE"
}

dependencies {
    implementation(project(path = ":service"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-web")
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "com.company.application.StartApplication"
    }

    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

val commandArgs = listOf("java",
        "-Dsun.security.jgss.native=true",
        "-Dsun.security.jgss.lib=/usr/local/libexec/libgsswrap.so",
        "-jar", jar.archiveFile.get())

task<Exec>("start") {
    dependsOn("build")
    group = "Execution"
    description = "Start the application post running build and using generated jar file."
    commandLine(commandArgs)
}

task<Exec>("startFast") {
    dependsOn(jar)
    group = "Execution"
    description = "Start the application using last generated jar file."
    commandLine(commandArgs)
}