import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "nl.chrisb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
    implementation("com.charleskorn.kaml:kaml:0.37.0")
    implementation("com.github.ajalt.mordant:mordant:2.0.0-beta3")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
