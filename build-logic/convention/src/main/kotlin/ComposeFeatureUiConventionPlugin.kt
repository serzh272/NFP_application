/*
 * Copyright 2022 The Android Open Source Project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

import com.android.build.gradle.LibraryExtension
import ext.libs
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("MagicNumber")
class ComposeFeatureUiConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("com.google.devtools.ksp")
                apply("com.google.dagger.hilt.android")
            }
            extensions.configure<LibraryExtension> {
                compileSdk = COMPILE_SDK_VERSION
                val featureName = path.split(":").getOrElse(2){ "feature" }
                namespace = "ru.serzh272.nfp.$featureName.ui"
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = libs.findVersion("composeCompiler").get().toString()
                }

                buildFeatures {
                    compose = true
                }

                dependencies {
                    add("implementation", project(":core:ui"))
                    add("implementation", project(":core:common"))
                    add("implementation", project(path.replace("$featureName:ui", "$featureName:domain")))
                    add("implementation", libs.findLibrary("composeUi").get())
                    add("implementation", libs.findLibrary("composePreview").get())
                    add("implementation", libs.findLibrary("composeMaterial").get())
                    add("implementation", libs.findLibrary("hilt").get())
                    add("ksp", libs.findLibrary("hiltCompiler").get())
                    add("implementation", libs.findLibrary("composeNavigation").get())
                    add("testImplementation", libs.findLibrary("junit").get())
                    add("androidTestImplementation", libs.findLibrary("junitExt").get())
                    add("androidTestImplementation", libs.findLibrary("espressoCore").get())
                }
            }
        }
    }
}
