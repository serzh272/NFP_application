plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
}

android {
    namespace = "ru.serzh272.nfp"
    compileSdkVersion(33)

    defaultConfig {
        applicationId = "ru.serzh272.nfp"
        minSdkVersion(23)
        targetSdkVersion(33)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        javaCompileOptions {
            annotationProcessorOptions {
                argument("room.schemaLocation", "$projectDir/schemas".toString())
                argument("room.incremental","true")
            }
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
