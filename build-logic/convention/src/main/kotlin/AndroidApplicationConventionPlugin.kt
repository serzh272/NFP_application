import com.android.build.api.dsl.ApplicationExtension
import ext.configureKotlinAndroid
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("MagicNumber")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.apply {
                    targetSdk = TARGET_SDK_VERSION
                    minSdk = MIN_SDK_VERSION
                }
                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeUiVersion").get().toString()
                }

                buildFeatures {
                    compose = true
                }

                buildTypes {
                    getByName("release") {
                        isMinifyEnabled = true
                        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
                    add("implementation", project(":feature:ui:norms"))
                    add("implementation", project(":feature:domain:norms"))
                    add("implementation", project(":core:ui"))
                    add("implementation", project(":core:common"))
                    add("kapt", libs.findLibrary("hiltCompiler").get())
                }

            }
        }
    }
}
