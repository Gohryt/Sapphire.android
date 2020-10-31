package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import androidx.appcompat.app.AppCompatActivity
import libgo.Libgo
import java.util.*

class Main : AppCompatActivity() {
    private var session: Boolean = false
    private var properties: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        Libgo.setProjectVariables(
            applicationInfo.packageName,
            applicationInfo.dataDir,
            android.os.Build.VERSION.RELEASE,
            android.os.Build.SUPPORTED_ABIS[0],
            android.os.Build.MODEL,
            Locale.getDefault().language,
            Secure.getString(getContentResolver(), Secure.ANDROID_ID),
            android.os.Build.VERSION.SDK_INT,
            windowManager.defaultDisplay.height,
            windowManager.defaultDisplay.width
        )
        session = Libgo.checkSession()
        properties = Libgo.checkProperties()
        setTheme(R.style.Sapphire)
        setContentView(R.layout.main)
        super.onCreate(savedInstanceState)
    }
}