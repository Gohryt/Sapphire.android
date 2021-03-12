package gohryt.sapphire

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import engine.*
import gohryt.sapphire.resources.*

@RequiresApi(Build.VERSION_CODES.R)
class Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.run {
            statusBarColor = Color.TRANSPARENT
            navigationBarColor = Color.TRANSPARENT
            WindowCompat.setDecorFitsSystemWindows(this, false)
        }

        val metrics = DisplayMetrics()
        display?.getRealMetrics(metrics)

        B.run {
            strings = Strings(this@Activity)
            routes = Routes(this@Activity)
            errors = Errors(this@Activity)
            colors = Colors(this@Activity)
            icons = Icons(this@Activity)
            typefaces = Typefaces(this@Activity)
        }

        setContent {
            Column (modifier = Modifier.padding(all = 30.dp)) {
                val x = remember { mutableStateOf(0) }
                val y = remember { mutableStateOf(B.colors.backgroundAccent) }
                BasicText(text = "Привет ${x.value}", style = B.typefaces.h3.merge(TextStyle(color = B.colors.foregroundMain)))
                Icon(
                    imageVector = B.icons.like,
                    contentDescription = "like",
                    tint = y.value,
                    modifier = Modifier.clickable {
                        if (x.value < 10) {
                            x.value++
                        }
                        if (x.value == 10) {
                            y.value = B.colors.foregroundPoor
                        }
                    }
                )
            }
        }
    }

    override fun onPause() {
        super.onPause()
        Engine.gc()
        System.gc()
    }
}