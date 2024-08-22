plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.example.tmdbclient"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tmdbclient"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField ("String","API_KEY","\"1f5fed9e7f0c788ee9e18179fc1de0b7\"")
        buildConfigField ("String","BASE_URL","\"https://api.themoviedb.org/3/\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
   buildFeatures{
       dataBinding = true
       buildConfig = true
   }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    // ViewModel
    implementation(libs.androidx.lifecycle.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    // Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    // Annotation processor
    kapt(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.room.runtime)
    kapt(libs.androidx.room.room.compiler)
    // To use Kotlin Symbol Processing (KSP)
    kapt(libs.androidx.room.room.compiler)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    //dagger
    implementation(libs.dagger)
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    //okhhtp logging interceptor
    implementation(libs.logging.interceptor)
    //glide
    implementation(libs.glide)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}