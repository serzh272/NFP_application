pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs{
        create("libs"){
            version("composeUiVersion", "1.4.3")
            version("roomVersion", "2.5.1")
            library("androidCoreKtx", "androidx.core:core-ktx:1.10.1")
            library("lifecycleRuntimeKtx", "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
            library("activityCompose", "androidx.activity:activity-compose:1.7.1")
            library("roomRuntime", "androidx.room", "room-runtime").versionRef("roomVersion")
            library("roomCompiler", "androidx.room", "room-compiler").versionRef("roomVersion")
            library("roomKtx", "androidx.room", "room-ktx").versionRef("roomVersion")
            library("roomPaging", "androidx.room", "room-paging").versionRef("roomVersion")
            library("composeUi", "androidx.compose.ui", "ui").versionRef("composeUiVersion")
            library("composePreview", "androidx.compose.ui", "ui-tooling-preview").versionRef("composeUiVersion")
            library("composeNavigation", "androidx.navigation:navigation-compose:2.5.3")
            library("composeMaterial", "androidx.compose.material:material:1.4.3")
            library("accompanistFlowLayout", "com.google.accompanist:accompanist-flowlayout:0.28.0")
            library("hilt", "com.google.dagger:hilt-android:2.44.2")
            library("hiltComposeNavigation", "androidx.hilt:hilt-navigation-compose:1.0.0")
            library("hiltCompiler", "com.google.dagger:hilt-compiler:2.44.2")
            library("junit", "junit:junit:4.13.2")
            library("roomTesting", "androidx.room", "room-testing").versionRef("roomVersion")
            library("junitExt", "androidx.test.ext:junit:1.1.5")
            library("espressoCore", "androidx.test.espresso:espresso-core:3.5.1")
            library("junitUi", "androidx.compose.ui", "ui-test-junit4").versionRef("composeUiVersion")
            library("debugComposeUiTooling", "androidx.compose.ui", "ui-tooling").versionRef("composeUiVersion")
            library("debugComposeUiTestManifest", "androidx.compose.ui", "ui-test-manifest").versionRef("composeUiVersion")

            bundle("room", listOf("roomRuntime", "roomKtx", "roomPaging"))
        }
    }
}
rootProject.name = "NFP"
include (":app")
