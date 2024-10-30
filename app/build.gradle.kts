plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.ktorhttpserver"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ktorhttpserver"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "META-INF/INDEX.LIST"
            excludes += "META-INF/io.netty.versions.properties"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    var ktor_version = "3.0.0"
// Ktor的核心包
    implementation ("io.ktor:ktor-server-core:$ktor_version")
// 供Ktor使用的引擎包，另外有Jetty, Tomcat, CIO可用
    implementation ("io.ktor:ktor-server-netty:$ktor_version")
// 用於印出Request及Response的log用
    implementation ("io.ktor:ktor-server-call-logging:$ktor_version")
// 用於支援PartialContent用
    implementation ("io.ktor:ktor-server-partial-content:$ktor_version")
// 用於支援CORS用
    implementation ("io.ktor:ktor-server-cors:$ktor_version")
// 用於回傳客製html用
    implementation ("io.ktor:ktor-server-html-builder:$ktor_version")
    implementation ("io.ktor:ktor-client-gson:$ktor_version")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}