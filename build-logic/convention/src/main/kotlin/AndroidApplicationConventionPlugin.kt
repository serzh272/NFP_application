import com.android.build.api.dsl.ApplicationExtension
import ext.configureKotlinAndroid
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import java.io.File
import java.io.FileInputStream
import java.util.Properties

@Suppress("MagicNumber")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.apply {
                    targetSdk = TARGET_SDK_VERSION
                    minSdk = MIN_SDK_VERSION
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
                }
                val keystorePropertiesFile = rootProject.file("keystore.properties")
                val keystoreProperties = Properties()
                keystoreProperties.load(FileInputStream(keystorePropertiesFile))
                signingConfigs {
                    create("release") {
                        storeFile = file(keystoreProperties["storeFile"] as String)
                        keyPassword = keystoreProperties["keyPassword"] as String
                        keyAlias = keystoreProperties["keyAlias"] as String
                        storePassword = keystoreProperties["storePassword"] as String
                    }
                }

                buildFeatures {
                    compose = true
                }
                flavorDimensions += listOf("mode")
                productFlavors {
                    create("demo") {
                        dimension = "mode"
                        applicationIdSuffix = ".demo"
                    }
                    create("full") {
                        dimension = "mode"
                    }
                }

                buildTypes {
                    getByName("release") {
                        signingConfig = signingConfigs.getByName("release")
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
                    }
                    getByName("debug") {
                        applicationIdSuffix = ".dev"
                    }
                }
                defaultConfig {
                    vectorDrawables {
                        useSupportLibrary = true
                        versionCode = 1
                        versionName = "1.0"
                    }
                }

                packaging {
                    resources {
                        excludes += "/META-INF/{AL2.0,LGPL2.1}"
                    }
                }

                dependencies {
                    add("implementation", project(":data"))
                    add("implementation", project(":domain"))
                    add("implementation", project(":core:ui"))
                    add("implementation", project(":core:common"))
                    add("ksp", libs.findLibrary("hiltCompiler").get())
                }
            }
        }
    }
}
