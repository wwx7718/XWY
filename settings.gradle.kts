pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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
<<<<<<< HEAD
}

rootProject.name = "UI practice"
include(":app")
 
=======

    versionCatalogs{
        create("libs")
    }
}

rootProject.name = "Application"
include(":app")
>>>>>>> 54e6154 (screenpreview)
