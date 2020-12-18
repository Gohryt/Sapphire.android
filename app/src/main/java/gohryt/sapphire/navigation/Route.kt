package gohryt.sapphire.navigation

import android.content.Context
import android.view.View

data class Route(
    val address: String,
    val type: Int,
    val action: (Context) -> View
)