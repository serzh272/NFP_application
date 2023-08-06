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
}
rootProject.name = "NFP"
include (":app")
include(":feature:data:norms")
include(":feature:domain:norms")
include(":feature:ui:norms")
include(":data")
include(":core:common")
include(":core:ui")
