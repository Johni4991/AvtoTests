plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.codeborne:selenide:7.0.1")
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.1.2")

    testImplementation("org.aspectj:aspectjweaver:1.9.19")
    testImplementation("io.qameta.allure:allure-junit5:2.20.1")
    testImplementation("io.qameta.allure:allure-commandline:2.20.1")
    testImplementation("io.qameta.allure:allure-assertj:2.20.1")
    testImplementation("io.qameta.allure:allure-rest-assured:2.20.1")
    testImplementation("io.qameta.allure:allure-java-commons:2.20.1")
}
tasks.test {
    useJUnitPlatform()
}