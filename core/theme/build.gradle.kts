plugins {
    id("nfp.android.library")
}

android {
    namespace = "ru.serzh272.nfp.core.theme"
}

dependencies {
    implementation(libs.composeUi)
    implementation(libs.composeMaterial)
}
