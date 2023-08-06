@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.dagger.hilt.android)
}

android {
    namespace = "ru.serzh272.nfp"
    compileSdk = 33

    defaultConfig {
        applicationId = "ru.serzh272.nfp"
        minSdk = 24
        targetSdk = 33
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

    implementation(project(":data"))
    implementation(project(":feature:data:norms"))
    implementation(project(":feature:domain:norms"))
    implementation(project(":core:ui"))
    implementation(project(":core:common"))

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
