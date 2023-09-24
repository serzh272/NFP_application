@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
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

    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeMaterial)
}
