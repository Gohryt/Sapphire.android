package gohryt.sapphire.fragments

import android.content.Context
import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import gohryt.sapphire.resources.*

@RequiresApi(Build.VERSION_CODES.R)
object Auth {
    @Composable
    fun Default(
        navController: NavController,
        context: Context,
        resources: Resources,
        screen: Screen.Data,
        colors: Colors.Data,
        typography: Typography.Data,
        icons: Icons.Data
    ) {
        ScrollableColumn {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screen.statusBarHeightDp)
            )
            for (i in 1..25) {
                BasicText(text = "lol")
                BasicText(text = "kek")
            }
            BasicText(text = "1")
        }
    }
}