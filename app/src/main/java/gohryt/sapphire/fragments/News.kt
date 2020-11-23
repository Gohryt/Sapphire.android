package gohryt.sapphire.fragments

import android.content.Context
import android.content.res.Resources
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import gohryt.sapphire.models.Post
import gohryt.sapphire.resources.*

@RequiresApi(Build.VERSION_CODES.R)
object News {
    @Composable
    fun Default(
        navController: NavController,
        context: Context,
        resources: Resources,
        screen: Screen.Data,
        colors: Colors.Data,
        typography: Typography.Data,
        icons: Icons.Data,
    ) {
        ScrollableColumn(
            modifier = Modifier
                .padding(
                    all = 5.dp
                )
                .fillMaxSize()
        )
        {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(screen.statusBarHeight.dp)
            )
            for (i in 1..20) {
                Post.Default(
                    colors = colors,
                    typography = typography,
                    icons = icons
                )
            }
        }
    }
}