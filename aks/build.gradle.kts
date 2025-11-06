plugins {
    id("com.android.library")
}

android {
    namespace = "com.pentabit.aksdist"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    publishing {
        singleVariant("release")
    }
}

dependencies {
    // You can add any dependencies here if needed
}

// Include both AARs in the final output
afterEvaluate {
    val aarFiles = file("$projectDir/libs").listFiles { _, name ->
        name.endsWith(".aar")
    } ?: emptyArray()

    aarFiles.forEach { aar ->
        println("Including AAR: ${aar.name}")
        artifacts.add("default", aar)
    }
}
