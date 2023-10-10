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
include(":feature:norms:domain")
include(":feature:norms:ui")
include(":feature:profile:domain")
include(":feature:profile:ui")
include(":feature:results:domain")
include(":feature:results:ui")
include(":data")
include(":domain")
include(":core:common")
include(":core:ui")
include(":core:theme")
