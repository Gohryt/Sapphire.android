package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*
import libgo.*
import java.util.*

class Main : AppCompatActivity() {
    private lateinit var variables: VariablesStruct
    private lateinit var session: SessionStruct
    private lateinit var properties: PropertiesStruct
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        splash.visibility = View.VISIBLE
        variables = Libgo.setVariables(
            applicationInfo.packageName,
            applicationInfo.dataDir,
            android.os.Build.VERSION.RELEASE,
            android.os.Build.SUPPORTED_ABIS[0],
            android.os.Build.MODEL,
            Locale.getDefault().language,
            Secure.getString(contentResolver, Secure.ANDROID_ID),
            android.os.Build.VERSION.SDK_INT,
            windowManager.defaultDisplay.height,
            windowManager.defaultDisplay.width
        )
        session = Libgo.setSession()
        properties = Libgo.setProperties()
        splash.visibility = View.GONE
        button.setOnClickListener {
            Libgo.auth(editTextPhone.text.toString(), editTextTextPassword.text.toString())
            textView.text = session.accessToken
        }
    }
}