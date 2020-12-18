package gohryt.sapphire

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import engine.Engine

@RequiresApi(Build.VERSION_CODES.R)
class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Engine.initialize()
    }
}