package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import android.view.View
import android.widget.Toast
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
        logIn.visibility = View.VISIBLE
    }
    fun auth(view: View) {
        val auth = Libgo.auth(logIn_username.text.toString(), logIn_password.text.toString())
        when {
            auth.error == "invalid_client" && auth.errorType == "username_or_password_is_incorrect" -> {
                Toast.makeText(applicationContext, R.string.logInErrorIncorrect, Toast.LENGTH_SHORT).show()
            }
            auth.error == "need_validation" &&  auth.validationSid != "" && auth.redirectURI != "" -> {
                Toast.makeText(applicationContext, R.string.logInError2fa, Toast.LENGTH_SHORT).show()
            }
            auth.error != "" -> {
                Toast.makeText(applicationContext, R.string.logInErrorUnknown, Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(applicationContext, auth.toString(), Toast.LENGTH_SHORT).show()
            }
        }
    }
}