import org.jetbrains.kotlin.kapt3.base.Kapt.kapt
plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.4.21"
    //id ("com.google.devtools.ksp")
}
kotlin {
    val koin_version = "3.2.0"
    val ksp_version = "1.6.21-1.0.5"
    val ktorVersion = "2.0.2"

    android()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("dev.icerock.moko:mvvm-core:0.13.0")
                implementation("dev.icerock.moko:mvvm-livedata:0.13.0")
                implementation("dev.icerock.moko:mvvm-flow:0.13.0") // api mvvm-core, CFlow for native and binding extensions
                implementation ("io.insert-koin:koin-core:$koin_version")
                implementation("dev.icerock.moko:mvvm-state:0.13.0") // api mvvm-livedata, ResourceState class and extensions
                implementation("dev.icerock.moko:mvvm-livedata-resources:0.13.0") // api mvvm-core, moko-resources, extensions for LiveData with moko-resources
                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("org.jetbrains.kotlin:kotlin-serialization:1.6.21")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("dev.icerock.moko:mvvm-flow-compose:0.13.0") // api mvvm-flow, binding extensions for Jetpack Compose (jvm, js, android)
                implementation("dev.icerock.moko:mvvm-livedata-compose:0.13.0") // api mvvm-livedata, binding extensions for Jetpack Compose (jvm, js, android)
                implementation("dev.icerock.moko:mvvm-livedata-material:0.13.0") // api mvvm-livedata, Material library android extensions
                implementation("dev.icerock.moko:mvvm-livedata-glide:0.13.0") // api mvvm-livedata, Glide library android extensions
                implementation("dev.icerock.moko:mvvm-livedata-swiperefresh:0.13.0") // api mvvm-livedata, SwipeRefreshLayout library android extensions

                implementation ("io.insert-koin:koin-android:$koin_version")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation("io.ktor:ktor-client-darwin:$ktorVersion")
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 32
    }
}
kapt {
    correctErrorTypes = true
}