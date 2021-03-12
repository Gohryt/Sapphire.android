import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    private const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    private const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    private const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlin)
        add(coreKtx)
        add(appCompat)

        add(composeActivity)
        add(composeFoundation)
        add(composeUi)
    }
}

fun DependencyHandler.kapt(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}