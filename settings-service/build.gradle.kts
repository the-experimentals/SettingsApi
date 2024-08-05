plugins {
    id("org.springframework.boot")
}

dependencies {

    implementation(project(":settings-proto"))

//	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")

    implementation ("io.jsonwebtoken:jjwt:0.9.1")
    implementation ("org.modelmapper:modelmapper:3.1.1")

    implementation ("net.devh:grpc-server-spring-boot-starter:2.15.0.RELEASE")
    implementation ("net.devh:grpc-spring-boot-starter:2.14.0.RELEASE")
    implementation ("org.springdoc:springdoc-openapi-ui:1.7.0")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage:junit-vintage-engine")
    }
    testImplementation ("org.springframework.security:spring-security-test")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.6.2")
}