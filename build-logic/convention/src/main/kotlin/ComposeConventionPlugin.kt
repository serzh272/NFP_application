import com.android.build.gradle.LibraryExtension
import ext.configureKotlinAndroid
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

@Suppress("MagicNumber")
class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
                }

                buildFeatures {
                    compose = true
                }
            }
        }
    }
}
