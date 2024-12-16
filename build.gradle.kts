/*
 하위 모듈 버전 관리용
 apply false는 현재 모듈에서만 안쓰고, 하위 모듈들은 적용이 될 수 있다.
 */
plugins {
    java
    id("org.springframework.boot") version "3.4.0" apply false
    id("io.spring.dependency-management") version "1.1.6" apply false
}

/*
모든 프로젝트의 공통 적용사항이다.
 */
allprojects{
    group = "com.graceful.ratelimit"
    version = "0.0.1-SNAPSHOT"
    repositories {
        mavenCentral()
    }
}

// 하위 모듈 공통 적용용
subprojects {
    apply(plugin = "java")
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(21))
        }
    }
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}


tasks.withType<Test> {
    useJUnitPlatform()
}
