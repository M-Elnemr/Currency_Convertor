plugins {
    id ("com.android.application")
    kotlin("android")
    id ("kotlin-kapt")
    id ("kotlin-android-extensions")
    id ("androidx.navigation.safeargs.kotlin")
    id ("dagger.hilt.android.plugin")
    id ("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.shoptop.dashboard"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }

//        buildConfigField("String", "BASE_URL", """http://192.168.1.4:8000""")

    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }


    configurations.all {
        resolutionStrategy.force("com.google.code.findbugs:jsr305:1.3.9")
    }

    compileOptions {
        sourceCompatibility = ConfigData.sourceCompatibility
        targetCompatibility = ConfigData.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }

    buildFeatures {
        dataBinding = true
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    // Core
    implementation(Libs.core_ktx)
    implementation(Libs.app_compat)
    implementation(Libs.material)
    implementation(Libs.legacy_support)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Test
    testImplementation(TestLibs.junit)
    testImplementation(TestLibs.coroutines)
    testImplementation(TestLibs.truth)
    testImplementation(TestLibs.mockk)
    testImplementation(TestLibs.mockk_jvm)

    // Android Test
    androidTestImplementation(AndroidTestLibs.junit)
    androidTestImplementation(TestLibs.truth)
    androidTestImplementation(AndroidTestLibs.junit_compose)
    debugImplementation(AndroidTestLibs.debug_compose_ui)
    androidTestImplementation(AndroidTestLibs.arch_core)
    androidTestImplementation(TestLibs.coroutines)
    androidTestImplementation(TestLibs.mockk)
    androidTestImplementation(TestLibs.mockk_jvm)

    // ViewModel
    implementation(Libs.viewModel)

    // Coroutine
    implementation(Libs.coroutines_core)
    implementation(Libs.coroutines_android)

    // Kotlin Serialization
    implementation(Libs.kotlinx_serialization)

    // Room
    implementation(Libs.room_runtime)
    implementation(Libs.room_ktx)
    kapt(Libs.room_compiler_ksp)

    // Hilt
    implementation(Libs.hilt_android)
    kapt(Libs.hilt_compiler_dagger_kapt)
    kapt(Libs.hilt_compiler_android_kapt)

    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofit_converter_gson)
    implementation(Libs.retrofit_converter_moshi)
    implementation(Libs.kotshi)
    kapt(Libs.kotshi_compiler)
    implementation(Libs.moshi)
    implementation(Libs.retrofit_coroutines)

    // Lifecycle
    implementation(Libs.lifecycle_extensions)
    implementation(Libs.lifecycle)
    implementation(Libs.lifecycle_viewmodel)
    implementation(Libs.lifecycle_livedata)

    // Paging
    implementation(Libs.paging)

    // Navigation Component
    implementation(Libs.navigation_fragment)
    implementation(Libs.navigation_ui)

    // Layout
    implementation(Libs.coordinatorlayout)
    implementation(Libs.constraint_layout)

    // Data Binding
    kapt(Libs.databinding)
    kapt(Libs.databinding_compiler)

    // DataStore
    implementation(Libs.datastore)

    // Gson
    implementation(Libs.gson)

    // Jsoup
    implementation(Libs.jsoup)

    // Ok http
    implementation(Libs.okhttp_logging)
    implementation(Libs.okhttp)

    // ExpansionPanel
    implementation(Libs.expansion_panel)

    // MultiSelectSpinner
    implementation(Libs.multiSelectSpinner)

}