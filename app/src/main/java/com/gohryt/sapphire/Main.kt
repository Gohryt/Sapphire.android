package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*
import libgo.Libgo
import libgo.PropertiesStruct
import libgo.SessionStruct
import java.util.*

class Main : AppCompatActivity() {
    private lateinit var session: SessionStruct
    private lateinit var properties: PropertiesStruct
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        splash.visibility = View.VISIBLE
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
        splash.visibility = View.GONE
    }
}