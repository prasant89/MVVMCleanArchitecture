import org.gradle.kotlin.dsl.androidTestImplementation
import org.gradle.kotlin.dsl.libs

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.prasant.binapani"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.prasant.binapani"
        minSdk = 24
        targetSdk = 33
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.recyclerview)
    testImplementation(libs.junit)
    runtimeOnly(libs.hilt.android)
    runtimeOnly(libs.androidx.room.runtime)

    implementation(libs.material3)
    implementation(libs.androidx.material)
    implementation(libs.ui)
    implementation (libs.androidx.material.icons.extended)

    implementation (libs.androidx.runtime.livedata)
    implementation (libs.androidx.lifecycle.lifecycle.runtime.compose)

    // Lifecycle components
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    // Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    implementation (libs.kotlinx.coroutines.core.v160)
    implementation (libs.kotlinx.coroutines.android.v160)


    // Retrofit for network calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Core Hilt Dependency
    implementation(libs.hilt.android.v2511) // Latest stable version
    kapt(libs.hilt.android.compiler)        // Compiler for Hilt

    // Optional: Hilt for WorkManager (if using WorkManager)
    implementation(libs.androidx.work.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    implementation (libs.lottie.compose)
    implementation(libs.androidx.hilt.navigation.compose.v120)

    //Compose viewmodel
    implementation(libs.activity.compose.v172)
    implementation(libs.androidx.lifecycle.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.compose)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.org.jetbrains.kotlinx.kotlinx.coroutines.android.v173.x2)

    //Coil Image
    implementation(libs.coil.compose)

    // Retrofit
    implementation(libs.retrofit.v290)
    implementation(libs.converter.gson.v290)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}

kapt {
    correctErrorTypes = true
}