
plugins {
	id("org.springframework.boot") version "2.6.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	id("com.google.protobuf") version "0.8.15"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "mono"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

apply(plugin = "kotlin")

repositories {
	mavenCentral()
}

dependencies {
	// kotlin
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")

	// lombok
	implementation("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	// webflux
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	// armeria
	implementation("com.linecorp.armeria:armeria-grpc")
	implementation("com.linecorp.armeria:armeria-spring-boot2-webflux-starter")

	// log
	implementation("io.github.microutils:kotlin-logging:1.12.5")
	implementation("ch.qos.logback:logback-classic:1.2.3")

	// protobuf
	api("com.google.protobuf:protobuf-java-util:3.17.0")

	// grpc
	api("io.grpc:grpc-kotlin-stub:1.0.0")
	api("io.grpc:grpc-protobuf:1.39.0")
	api("io.grpc:grpc-netty-shaded:1.39.0")
}

dependencyManagement {
	imports {
		mavenBom("com.linecorp.armeria:armeria-bom:0.99.9")
		mavenBom("io.netty:netty-bom:4.1.51.Final")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

sourceSets {
	main {
		java {
			srcDirs(
				"mono-idl/build/generated/source/main/grpc",
				"mono-idl/build/generated/source/main/java",
				"mono-idl/build/generated/source/main/grpckt"
			)
		}
	}
}