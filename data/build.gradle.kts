plugins {
    id("nfp.android.library")
    alias(libs.plugins.ksp)
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

    implementation(project(":feature:norms:domain"))
    implementation(project(":feature:profile:domain"))
    implementation(project(":domain"))

    implementation(libs.androidCoreKtx)

    api(libs.bundles.room)
    ksp(libs.roomCompiler)

    implementation(libs.hilt)
    ksp(libs.hiltCompiler)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junitExt)
    androidTestImplementation(libs.espressoCore)
}
