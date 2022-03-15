import org.gradle.api.JavaVersion

object ConfigData {
    const val compileSdkVersion = 32
    const val minSdkVersion = 21
    const val targetSdkVersion = compileSdkVersion
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"

    // Compatibility
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
}

object BuildPlugins{
    val android by lazy{"com.android.tools.build:gradle:${Versions.gradlePlugin}"}
    val kotlin by lazy{"org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"}
    val navigation by lazy{"androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"}
    val hilt by lazy{"com.google.dagger:hilt-android-gradle-plugin:2.40.5:${Versions.hilt}"}
    val mapsPlatform by lazy{"com.google.android.libraries.mapsplatform.secrets-gradle-plugin:secrets-gradle-plugin:${Versions.mapsPlatform}"}
}

object Libs{

    // Core
    val core_ktx by lazy {"androidx.core:core-ktx:${Versions.core_ktx}"}
    val app_compat by lazy {"androidx.appcompat:appcompat:${Versions.app_compat}"}
    val material by lazy {"com.google.android.material:material:${Versions.material}"}
    val legacy_support by lazy {"androidx.legacy:legacy-support-v4:${Versions.legacy_support}"}

    // ViewModel
    val viewModel by lazy {"androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"}

    // Coroutine
    val coroutines_core by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"}
    val coroutines_android by lazy {"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"}

    // Kotlin Serialization
    val kotlinx_serialization by lazy {"org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization}"}

    // Room
    val room_runtime by lazy {"androidx.room:room-runtime:${Versions.room}"}
    val room_ktx by lazy {"androidx.room:room-ktx:${Versions.room}"}
    val room_compiler_ksp by lazy {"androidx.room:room-compiler:${Versions.room}"}

    // Hilt
    val hilt_android by lazy {"com.google.dagger:hilt-android:${Versions.hilt}"}
    val hilt_compiler_dagger_kapt by lazy {"com.google.dagger:hilt-compiler:${Versions.hilt}"}
    val hilt_compiler_android_kapt by lazy {"androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"}

    // Retrofit
    val retrofit by lazy {"com.squareup.retrofit2:retrofit:${Versions.retrofit}"}
    val retrofit_converter_gson by lazy {"com.squareup.retrofit2:converter-gson:${Versions.retrofit}"}
    val retrofit_converter_moshi by lazy {"com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"}
    val kotshi by lazy {"se.ansman.kotshi:api:${Versions.kotshi}"}
    val kotshi_compiler by lazy {"se.ansman.kotshi:compiler:${Versions.kotshi}"}
    val moshi by lazy {"com.squareup.moshi:moshi-kotlin:${Versions.moshi}"}
    val retrofit_coroutines by lazy {"com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofit_coroutines}"}

    // Lifecycle
    val lifecycle_extensions by lazy {"androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_extensions}"}
    val lifecycle by lazy {"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"}
    val lifecycle_viewmodel by lazy {"androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"}
    val lifecycle_livedata by lazy {"androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"}

    // Paging
    val paging by lazy {"androidx.paging:paging-runtime-ktx:${Versions.paging}"}

    // Navigation Component
    val navigation_fragment by lazy {"androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"}
    val navigation_ui by lazy {"androidx.navigation:navigation-ui-ktx:${Versions.navigation}"}

    // Layout
    val coordinatorlayout by lazy {"androidx.coordinatorlayout:coordinatorlayout:${Versions.coordinatorlayout}"}
    val constraint_layout by lazy {"androidx.constraintlayout:constraintlayout:${Versions.constraint_layout}"}

    // Data Binding
    val databinding by lazy {"androidx.databinding:databinding-common:${Versions.databinding}"}
    val databinding_compiler by lazy {"com.android.databinding:compiler:${Versions.databinding_compiler}"}

    // DataStore
    val datastore by lazy {"androidx.datastore:datastore-preferences:${Versions.datastore}"}

    // Gson
    val gson by lazy {"com.google.code.gson:gson:${Versions.gson}"}

    // Jsoup
    val jsoup by lazy {"org.jsoup:jsoup:${Versions.jsoup}"}

    // Ok http
    val okhttp_logging by lazy {"com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"}
    val okhttp by lazy {"com.squareup.okhttp3:okhttp:${Versions.okhttp}"}

    // ExpansionPanel
    val expansion_panel by lazy {"com.github.florent37:expansionpanel:${Versions.expansion_panel}"}

    // MultiSelectSpinner
    val multiSelectSpinner by lazy {"com.github.pratikbutani:MultiSelectSpinner:${Versions.multiSelectSpinner}"}

    // Dexter
    val dexter by lazy {"com.karumi:dexter:${Versions.dexter}"}

}


object TestLibs {
    val junit by lazy{"junit:junit:${Versions.junit}"}
    val coroutines by lazy{"org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"}
    val truth by lazy{"com.google.truth:truth:${Versions.truth}"}
    val mockk by lazy{"io.mockk:mockk:${Versions.mockk}"}
    val mockk_jvm by lazy{"io.mockk:mockk-agent-jvm:${Versions.mockk}"}
    val robolectric by lazy{"org.robolectric:robolectric:${Versions.robolectric}"}
}

object AndroidTestLibs {
    val junit by lazy{"androidx.test.ext:junit:${Versions.junit_android}"}
    val junit_compose by lazy{"androidx.compose.ui:ui-test-junit4:${Versions.compose}"}
    val debug_compose_ui by lazy{"androidx.compose.ui:ui-tooling:${Versions.compose}"}
    val arch_core by lazy{"androidx.arch.core:core-testing:${Versions.arch_core}"}
}