import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "ru.serzh272.nfp.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "nfp.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidFeatureUi") {
            id = "nfp.android.featureUi"
            implementationClass = "ComposeFeatureUiConventionPlugin"
        }
        register("androidFeatureData") {
            id = "nfp.android.featureData"
            implementationClass = "FeatureDataConventionPlugin"
        }
        register("androidFeatureDomain") {
            id = "nfp.android.featureDomain"
            implementationClass = "FeatureDomainConventionPlugin"
        }
        register("androidLibrary") {
            id = "nfp.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidCompose") {
            id = "nfp.android.compose"
            implementationClass = "ComposeConventionPlugin"
        }
    }
}
