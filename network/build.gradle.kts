plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.aram.mehrabyan.network"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        buildFeatures.buildConfig = true

        buildConfigField(
            type = "String",
            name = "API_KEY",
            value = "\"47117783-c7ad79934807599452c45f289\""
        )
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.koin.core)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp)
}