plugins{
    jacoco
    java
    id("io.spring.dependency-management") version "1.1.6"
    id("com.google.protobuf") version "0.10.0" apply false
    id("org.springframework.boot") version "3.3.2" apply false
}

tasks{
    java{
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }

    jar{
        enabled = false
    }

    test{
        useJUnitPlatform()
    }
}

allprojects {
    group = "com.tmsolution.settings"
    version = "0.0.1-SNAPSHOT"
}

subprojects {

    apply {
        plugin("java")
        plugin("jacoco")
        plugin("io.spring.dependency-management")
    }

    afterEvaluate {
        dependencyManagement{
            imports {
                mavenBom("org.springframework.boot:spring-boot-dependencies:3.3.2")
            }
        }
    }
}