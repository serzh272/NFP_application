plugins {
    id("nfp.android.library")
    id("nfp.android.compose")
}

android {
    namespace = "ru.serzh272.nfp.core.theme"
}

dependencies {
    implementation(libs.composeUi)
    implementation(libs.composeMaterial)
}
