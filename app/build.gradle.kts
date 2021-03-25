plugins {
    id("com.android.application")
    kotlin("android")
}
android {
    compileSdkVersion(Config.compileSdk)
    buildToolsVersion(Config.buildToolsVersion)

    ndkVersion = Config.ndkVersion

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
        sourceCompatibility(Versions.java)
        targetCompatibility(Versions.java)
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = Versions.java
        useIR = true
    }
    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}
dependencies {
    Dependencies.library.forEach { dependency ->
        implementation(dependency)
    }
    implementation("com.google.accompanist:accompanist-insets:0.6.2")
}