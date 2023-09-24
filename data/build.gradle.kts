@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    id("nfp.android.library")
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "ru.serzh272.nfp.data"

    defaultConfig {

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas")
                argument("room.incremental","true")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(project(":feature:domain:norms"))
    implementation(project(":feature:domain:profile"))
    implementation(project(":domain"))

    implementation(libs.androidCoreKtx)

    api(libs.bundles.room)
    kapt (libs.roomCompiler)

    implementation(libs.hilt)
    kapt(libs.hiltCompiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.espressoCore)
}
