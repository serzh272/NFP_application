package ext

import COMPILE_SDK_VERSION
import MIN_SDK_VERSION
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *>,) {
        commonExtension.apply {
            compileSdk = COMPILE_SDK_VERSION
            defaultConfig.apply {
                minSdk = MIN_SDK_VERSION
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
}
