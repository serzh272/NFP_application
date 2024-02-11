plugins {
    id("nfp.android.application")
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

    implementation(project(":feature:norms:ui"))
    implementation(project(":feature:norms:domain"))
    implementation(project(":feature:profile:ui"))
    implementation(project(":feature:profile:domain"))
    implementation(project(":feature:results:ui"))
    implementation(project(":feature:results:domain"))

    implementation(libs.androidCoreKtx)
    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.activityCompose)

    implementation(libs.bundles.room)
    ksp(libs.roomCompiler)

    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeNavigation)
    implementation(libs.composeMaterial)

    implementation(libs.hilt)
    implementation(libs.hiltComposeNavigation)

    testImplementation(libs.junit)
    testImplementation(libs.roomTesting)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.espressoCore)
    androidTestImplementation(libs.junitUi)
    debugImplementation(libs.debugComposeUiTooling)
    debugImplementation(libs.debugComposeUiTestManifest)
}
