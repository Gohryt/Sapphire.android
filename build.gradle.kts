buildscript {
    repositories {
        google()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.gradle}")
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