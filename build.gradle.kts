plugins {
    `java-library`
    `maven-publish`
    kotlin("jvm") version "1.9.20-RC"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo1.maven.org/maven2/")
    }

    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }

    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
    mavenCentral()
}

dependencies {
    api("com.konghq:unirest-java:3.13.13")

//    compileOnly("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.21")
    compileOnly(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
}

group = "me.aroze"
version = "1.0"

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
kotlin {
    jvmToolchain(8)
}