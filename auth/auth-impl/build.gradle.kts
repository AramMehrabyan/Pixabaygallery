plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.aram.mehrabyan.authimpl"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }
    buildFeatures {
        viewBinding = true
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
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    implementation(libs.koin.android)
    implementation(libs.koin.core)
    implementation(libs.androidx.navigation.fragment.ktx)


    implementation(project(":auth:auth-api"))
    implementation(project(":gallery:api"))
    implementation(project(":utils"))
}