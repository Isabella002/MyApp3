plugins {
    id("com.android.application") version "8.2.2" apply false
    // Include other plugins as needed
}
buildscript {
    repositories {
        google()
    }
    dependencies {
        val nav_version = "2.7.7"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}

