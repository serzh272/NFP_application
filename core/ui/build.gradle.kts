plugins {
    id("nfp.android.library")
    id("nfp.android.compose")
}

android {
    namespace = "ru.serzh272.nfp.core.ui"

}

dependencies {

    api(project(":core:theme"))
    implementation(libs.androidCoreKtx)

    implementation(libs.lifecycleRuntimeKtx)
    implementation(libs.lifecycleViewmodelKtx)

    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeMaterial)
}
