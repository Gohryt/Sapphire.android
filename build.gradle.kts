buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-alpha11")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}")
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}