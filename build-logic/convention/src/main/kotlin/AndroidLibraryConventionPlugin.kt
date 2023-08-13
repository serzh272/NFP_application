import com.android.build.gradle.LibraryExtension
import ext.configureKotlinAndroid
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("MagicNumber")
class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeUiVersion").get().toString()
                }

                buildFeatures {
                    compose = true
                }

                dependencies {
                    add("implementation", project(":core:common"))
                }
            }
        }
    }
}
