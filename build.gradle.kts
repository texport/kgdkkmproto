plugins {
    `java-library`
    `maven-publish`
}

group = "com.mybrain"
version = "2.0.2"

java {
    withSourcesJar()
}

tasks.register<Jar>("proto") {
    archiveBaseName.set("kgdkkmproto")
    archiveVersion.set(project.version.toString())
    from("proto")
    include("**/*.proto")
    into("proto")
}

publishing {
    publications {
        create<MavenPublication>("proto") {
            artifactId = "kgdkkmproto"
            version = project.version.toString()
            artifact(tasks["proto"])
        }
    }
}
