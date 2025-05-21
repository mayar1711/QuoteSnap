plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")

}

android {
    namespace = "com.example.quotesnap"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.quotesnap"
        minSdk = 24
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")


// Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1")

// Koin
    implementation("io.insert-koin:koin-android:3.5.0")
    implementation("io.insert-koin:koin-androidx-compose:3.5.0")

    //MockK
    testImplementation("io.mockk:mockk:1.14.2")
    testImplementation("io.mockk:mockk-agent-jvm:1.14.2")
    androidTestImplementation("io.mockk:mockk-android:1.14.2")
    androidTestImplementation("io.mockk:mockk-agent-android:1.14.2")
    androidTestImplementation("io.mockk:mockk-agent-jvm:1.14.2")


    //kotlinx-coroutines
    testImplementation (libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)
    androidTestImplementation (libs.org.jetbrains.kotlinx.kotlinx.coroutines.test)
    testImplementation(kotlin("test"))


    // hamcrest
    testImplementation (libs.hamcrest)
    testImplementation (libs.hamcrest.library)
    androidTestImplementation (libs.hamcrest)
    androidTestImplementation (libs.hamcrest.library)

    testImplementation (libs.robolectric)

    //navigation
    implementation(libs.androidx.compose.navigation)

    //Room
    implementation(libs.androidx.room.runtime)
    annotationProcessor(libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)
    ksp (libs.androidx.room.compiler)

}