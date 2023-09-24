pluginManagement {
    includeBuild("build-logic")
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
}
rootProject.name = "NFP"
include(":app")
include(":feature:domain:norms")
include(":feature:ui:norms")
include(":feature:domain:profile")
include(":feature:ui:profile")
include(":data")
include(":core:common")
include(":core:ui")
include(":core:theme")
