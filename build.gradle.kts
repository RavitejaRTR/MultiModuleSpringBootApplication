buildscript {
    repositories {
        mavenCentral()
    }
}

description = "Multi module springBoot application"

plugins {
    id("java")
    id("idea")
    id("war")
    id("application")
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

subprojects {
    group = "com.company.application"
    version = "0.0.1"

    repositories {
        mavenCentral()
    }

    apply {
        plugin("java")
        plugin("idea")
        plugin("io.spring.dependency-management")
    }

    java.sourceCompatibility = org.gradle.api.JavaVersion.VERSION_1_8

    dependencies {
        implementation("io.jsonwebtoken:jjwt-api:0.10.7")
        implementation("io.jsonwebtoken:jjwt-impl:0.10.7")
        implementation("com.auth0:java-jwt:3.10.3")

        implementation(group = "org.mockito", name = "mockito-core", version = "3.1.0")

        implementation(group = "javax.inject", name = "javax.inject", version = "1")
        implementation(group = "org.springframework", name = "spring-context", version = "5.2.6.RELEASE")
        implementation(group = "org.springframework.security", name = "spring-security-core", version = "4.2.3.RELEASE")

        implementation(group = "org.apache.commons", name = "commons-lang3", version = "3.7")
        implementation(group = "com.google.guava", name = "guava", version = "29.0-jre")
        implementation(group = "commons-io", name = "commons-io", version = "2.7")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
    }
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
