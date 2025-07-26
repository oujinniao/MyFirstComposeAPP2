plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    //alias(libs.plugins.kotlin.parcelize)
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.myfirstcomposeapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myfirstcomposeapp"
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
        freeCompilerArgs += listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check")
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
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

    implementation(libs.coil.compose)

    implementation("com.airbnb.android:lottie-compose:5.2.0")
    implementation("androidx.compose.material:material-icons-extended-android:1.7.8")
    implementation(libs.androidx.foundation.layout.android)

    implementation(libs.constraint.layout.compose)

    implementation(libs.androidx.navigation.compose)
   // implementation(libs.androidx.navigation.serialization)

    implementation(libs.androidx.datastore.preferences)

    implementation(libs.kotlinx.serialization.json)

    implementation(libs.androidx.core.splashscreen)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
