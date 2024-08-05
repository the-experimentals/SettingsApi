plugins{
    jacoco
    java
    id("io.spring.dependency-management") version "1.1.0"
    id("com.google.protobuf") version "0.9.1" apply false
    id("org.springframework.boot") version "3.0.5" apply false
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
                mavenBom("org.springframework.boot:spring-boot-dependencies:3.0.5")
            }
        }
    }
}