@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("nfp.android.application")
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    namespace = "ru.serzh272.nfp"

    defaultConfig {
        applicationId = "ru.serzh272.nfp"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    }
}

dependencies {

    implementation(libs.androidCoreKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.activityCompose)

    implementation(libs.bundles.room)
    kapt (libs.roomCompiler)

    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeNavigation)
    implementation(libs.composeMaterial)
    implementation(libs.accompanistFlowLayout)

    implementation(libs.hilt)
    implementation(libs.hiltComposeNavigation)
    kapt(libs.hiltCompiler)

    testImplementation(libs.junit)
    testImplementation(libs.roomTesting)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.junitUi)
    debugImplementation(libs.debugComposeUiTooling)
    debugImplementation(libs.debugComposeUiTestManifest)
}

kapt {
    correctErrorTypes = true
}
