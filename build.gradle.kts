plugins {
    kotlin("multiplatform") version "1.5.31"
    kotlin("plugin.serialization") version "1.5.31"
}

group = "nl.chrisb"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val jvmMain by getting {
            dependencies {
                implementation("io.github.cdimascio:dotenv-kotlin:6.2.2")
                implementation("com.charleskorn.kaml:kaml:0.37.0")
                implementation("com.github.ajalt.mordant:mordant:2.0.0-beta3")
                implementation("com.xenomachina:kotlin-argparser:2.0.7")
            }
        }
    }
}
