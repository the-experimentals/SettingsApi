plugins {

}

dependencies {

    implementation(project(":settings-proto"))

//	implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
    implementation ("org.springframework.boot:spring-boot-starter-security")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")

    implementation ("io.jsonwebtoken:jjwt:0.9.1")
//    implementation group: 'javax.xml.bind', name: 'jaxb-api', version: '2.4.0-b180830.0359'
    implementation ("org.modelmapper:modelmapper:2.4.4")
//
//    implementation group: 'io.grpc', name: 'grpc-netty', version: '1.51.0'
//    implementation group: 'io.grpc', name: 'grpc-protobuf', version: '1.51.0'
//    implementation group: 'io.grpc', name: 'grpc-stub', version: '1.51.0'
//    implementation group: 'com.google.protobuf', name: 'protobuf-java-util', version: '3.21.9'
//    implementation("javax.annotation:javax.annotation-api:1.3.2") {
//        because("gRPC generated stup requires for javax.annotations.")
//    }
//
//
    implementation ("net.devh:grpc-server-spring-boot-starter:2.14.0.RELEASE")
    implementation ("net.devh:grpc-spring-boot-starter:2.14.0.RELEASE")
//
    implementation ("org.springdoc:springdoc-openapi-ui:1.6.10")
//

    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude("org.junit.vintage:junit-vintage-engine")
    }
    testImplementation ("org.springframework.security:spring-security-test")
    testImplementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo.spring30x:4.6.2")
}