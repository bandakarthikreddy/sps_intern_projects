// build.gradle.kts (App-level)

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.compose")
}

android {
    namespace = "com.singlepointsol.roomdatabasetrying"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.singlepointsol.roomdatabasetrying"
        minSdk = 26
        targetSdk = 35
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3" // Update if needed
    }
}

dependencies {
    // Compose dependencies
    implementation(libs.androidx.compose.bom.v20241201)
    implementation(libs.ui)
    implementation(libs.material3)
    implementation(libs.ui.tooling.preview)
    debugImplementation(libs.ui.tooling)

    // AndroidX and lifecycle dependencies
    implementation(libs.androidx.core.ktx.v1120)
    implementation(libs.androidx.lifecycle.runtime.ktx.v262)
    implementation(libs.androidx.activity.compose)

    // Room database
    val roomVersion = "2.6.1"
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.compiler)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core.v351)
    androidTestImplementation(libs.ui.test.junit4)

    // Debugging dependencies
    debugImplementation(libs.androidx.compose.ui.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}
