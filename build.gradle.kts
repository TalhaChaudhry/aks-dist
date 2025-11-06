// Root build.gradle.kts
plugins {
    id("com.android.library") version "8.5.0" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
