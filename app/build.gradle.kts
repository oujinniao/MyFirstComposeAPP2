plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
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
    implementation(platform(libs.androidx.compose.bom)) // Asegura la compatibilidad de las versiones de Compose
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Dependencias de Coil (¡Solo una vez y la correcta!)
    // Asumimos que libs.coil.compose apunta a la versión 2.6.0 o superior en libs.versions.toml
    implementation(libs.coil.compose)
    // coil.network.okhttp es opcional, solo si necesitas integración específica con OkHttp
    // Si no tienes problemas de red y solo quieres cargar imágenes, coil.compose suele ser suficiente.
    // implementation(libs.coil.network.okhttp)

    // Otras librerías
    implementation("com.airbnb.android:lottie-compose:5.2.0") // Lottie para animaciones
    implementation("androidx.compose.material:material-icons-extended-android:1.7.8") // Iconos extendidos
    // Solo una instancia de foundation.layout.android
    implementation(libs.androidx.foundation.layout.android)

    // ConstraintLayout Compose (¡Solo una vez!)
    implementation(libs.constraint.layout.compose)


    // Dependencias de prueba
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
