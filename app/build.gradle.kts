import java.util.Properties

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.mehedi.beedatesting"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mehedi.beedatesting"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        android.buildFeatures.buildConfig = true
        val properties = Properties()
        if (rootProject.file("apikey.properties").exists()) {
            properties.load(rootProject.file("apikey.properties").inputStream())
        }
        val apiKey = properties.getProperty("API_KEY")
        defaultConfig {
            buildConfigField("String",
                "API_KEY",
                "\"$apiKey\"")

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
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }
        kotlinOptions {
            jvmTarget = "17"
        }
    }

    dependencies {

        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.11.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")

        // Material Design
        implementation("com.google.android.material:material:1.11.0")

        // Architectural Components
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")

        // Lifecycle
        implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")


        // Room
        implementation("androidx.room:room-runtime:2.6.1")
        //noinspection KaptUsageInsteadOfKsp
        kapt("androidx.room:room-compiler:2.6.1")

        // Kotlin Extensions and Coroutines support for Room
        implementation("androidx.room:room-ktx:2.6.1")

        // Retrofit
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")

        // Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

        // Coroutine Lifecycle Scopes
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

        // Navigation Components
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

        // Glide
        implementation("com.github.bumptech.glide:glide:4.16.0")
        //noinspection KaptUsageInsteadOfKsp
        kapt("com.github.bumptech.glide:compiler:4.16.0")

        // Activity KTX for viewModels()
        implementation("androidx.activity:activity-ktx:1.8.2")

        //Dagger - Hilt
        implementation("com.google.dagger:hilt-android:2.48")
        kapt("com.google.dagger:hilt-android-compiler:2.48")


        // Timber
        implementation("com.jakewharton.timber:timber:4.7.1")

        // Local Unit Tests
        implementation("androidx.test:core:1.5.0")
        testImplementation("junit:junit:4.13.2")
        testImplementation("org.hamcrest:hamcrest-all:1.3")
        testImplementation("androidx.arch.core:core-testing:2.2.0")
        testImplementation("org.robolectric:robolectric:4.3.1")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
        testImplementation("com.google.truth:truth:1.4.0")
        testImplementation("org.mockito:mockito-core:2.25.0")

        // Instrumented Unit Tests

//    androidTestImplementation("com.linkedin.dexmaker:dexmaker-mockito:2.12.1")
        androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
        androidTestImplementation("androidx.arch.core:core-testing:2.2.0")
        androidTestImplementation("com.google.truth:truth:1.4.0")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
        androidTestImplementation("org.mockito:mockito-core:2.25.0")
        androidTestImplementation("com.google.dagger:hilt-android-testing:2.28-alpha")
        kaptAndroidTest("com.google.dagger:hilt-android-compiler:2.48")


    }

    kapt {
        correctErrorTypes = true
    }}