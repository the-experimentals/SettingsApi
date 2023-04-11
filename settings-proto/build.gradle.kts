import com.google.protobuf.gradle.id

plugins{
    id("com.google.protobuf")
}

dependencies{
    implementation ("io.grpc:grpc-netty:1.51.0")
    implementation ("io.grpc:grpc-protobuf:1.51.0")
    implementation ("io.grpc:grpc-stub:1.51.0")
    implementation ("com.google.protobuf:protobuf-java-util:3.21.9")
    implementation("javax.annotation:javax.annotation-api:1.3.2") {
        because("gRPC generated stup requires for javax.annotations.")
    }
}

ext {
    set("snippetsDir", file("build/generated-snippets"))
}
//
sourceSets {
    main{
        proto{
            srcDir("src/main/protos")
        }
        java {
            srcDirs("build/generated/source/proto/main/grpc")
            srcDirs("build/generated/source/proto/main/java")
        }
    }
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.21.9"
    }

    plugins {
        create("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.51.0"
        }
    }
    generateProtoTasks {
        all().forEach { t ->
            t.plugins {
                id("grpc")
            }
        }
//        all()*.plugins {
//            grpc {}
//        }
    }
}