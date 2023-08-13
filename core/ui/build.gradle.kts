@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("nfp.android.library")
}

android {
    namespace = "ru.serzh272.core.ui"

}

dependencies {

    api(project(":core:theme"))
    implementation(libs.androidCoreKtx)

    implementation(libs.composeUi)
    implementation(libs.composePreview)
    implementation(libs.composeMaterial)
}
