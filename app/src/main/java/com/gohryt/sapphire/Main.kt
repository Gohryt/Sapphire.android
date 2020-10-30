package com.gohryt.sapphire

import android.app.Activity
import android.os.Bundle
import android.provider.Settings.Secure
import kotlinx.android.synthetic.main.login.*
import libgo.Libgo
import java.util.*


class Main : Activity() {
    private var session: Boolean = false
    private var properties: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Sapphire)
        super.onCreate(savedInstanceState)
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
    }

    override fun onStart() {
        super.onStart()
        session = Libgo.checkSession()
        properties = Libgo.checkProperties()
        if (!session) {
            setContentView(R.layout.login)
        } else {
            setContentView(R.layout.main)
        }
    }
}