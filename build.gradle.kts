plugins {
    id("java-library")
    id("com.google.protobuf") version "0.9.4"
    id("maven-publish")
}

group = "com.mybrain"
version = "2.0.2"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    withSourcesJar()
    modularity.inferModulePath.set(true)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:4.28.2")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:4.28.2"
    }
    generateProtoTasks {
        all().forEach {
            it.builtins.named("java")
        }
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "kgdkkmproto"
        }
    }
}