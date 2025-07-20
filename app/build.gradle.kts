plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    // Kotlin Serialization Plugin: ¡Añadido!
    alias(libs.plugins.kotlin.serialization) // <-- Añade esta línea
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
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Dependencias de AndroidX y Compose UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Dependencias de Coil
    implementation(libs.coil.compose)

    // Otras librerías
    implementation("com.airbnb.android:lottie-compose:5.2.0")
    implementation("androidx.compose.material:material-icons-extended-android:1.7.8")
    implementation(libs.androidx.foundation.layout.android)

    // ConstraintLayout Compose
    implementation(libs.constraint.layout.compose)

    // Dependencia de Navigation Compose
    implementation(libs.androidx.navigation.compose)

    // DataStore Preferences
    implementation(libs.androidx.datastore.preferences)

    // Kotlin Serialization Library: ¡Añadido!
    implementation(libs.kotlinx.serialization.json) // <-- Añade esta línea

    // Dependencias de prueba
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
