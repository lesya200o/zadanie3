plugins {
    id("org.springframework.boot") version "3.2.0"
    kotlin("jvm") version "1.9.20"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    runtimeOnly("org.postgresql:postgresql") // или H2 для тестов
}