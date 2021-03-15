object Dependencies {
    private const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    private const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    private const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    private const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"

    val library = arrayOf(
        kotlin,
        coreKtx,
        appCompat,

        composeFoundation,
        composeMaterial,
        composeUi
    )
}