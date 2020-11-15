package gohryt.sapphire.fragments

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp

@Composable
fun Auth(activity: AppCompatActivity) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .preferredHeight(24.dp)
    )
    BasicText(
        text = "HELL O",
        modifier = Modifier.clickable(onClick = {
            activity.setContent {
                News()
            }
        }).padding(24.dp)
    )
}