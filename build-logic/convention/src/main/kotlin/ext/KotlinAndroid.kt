package ext

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project

fun Project.configureKotlinAndroid(commonExtension: CommonExtension<*, *, *, *, *>,) {
        commonExtension.apply {
            compileSdk = 33
            defaultConfig.apply {
                minSdk = 24
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
        }
}
