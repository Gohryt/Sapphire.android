plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    compileSdkVersion(Config.compileSdk)
    buildToolsVersion(Config.buildToolsVersion)

    defaultConfig {
        applicationId = "gohryt.sapphire"

        minSdkVersion(Config.minSdk)
        targetSdkVersion(Config.targetSdk)
        versionCode(Config.versionCode)
        versionName(Config.versionName)
    }
    buildTypes {
        release {
            isMinifyEnabled = true
            multiDexEnabled = false

            proguardFiles("release.pro")
            debuggable(false)
            jniDebuggable(false)
            renderscriptDebuggable(false)
        }
        debug {
            isMinifyEnabled = true
            multiDexEnabled = false

            proguardFiles("debug.pro")
            debuggable(true)
            jniDebuggable(true)
            renderscriptDebuggable(true)
        }
    }
    splits {
        abi {
            isEnable = true
            isUniversalApk = false

            reset()
            include("armeabi-v7a", "arm64-v8a", "x86", "x86_64")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
        useIR = true
    }
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-alpha12"
    }
}
dependencies {
    implementation(fileTree(mapOf("include" to "engine.aar", "dir" to "libs")))
    implementation(Dependencies.appLibraries)
    implementation("androidx.compose.material:material:1.0.0-beta02")
}