package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main.*
import libgo.Libgo
import libgo.PropertiesStruct
import libgo.SessionStruct
import libgo.VariablesStruct
import java.util.*

class Main : AppCompatActivity() {
    private lateinit var variables: VariablesStruct
    private lateinit var session: SessionStruct
    private lateinit var properties: PropertiesStruct
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Sapphire)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
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
        if (session.accessToken != "" && session.userID != "" && session.webviewRefreshToken != "" && session.webviewAccessToken != "" && session.webviewAcessTokenExpiresIn != "") {

        } else {
            logIn_submit.setOnClickListener {
                val auth =
                    Libgo.auth(logIn_username.text.toString(), logIn_password.text.toString())
                when {
                    auth.error == "invalid_client" && auth.errorType == "username_or_password_is_incorrect" -> {
                        Toast.makeText(
                            applicationContext,
                            R.string.logInErrorIncorrect,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    auth.error == "need_validation" && auth.validationSid != "" && auth.redirectURI != "" -> {
                        Toast.makeText(
                            applicationContext,
                            R.string.logInError2fa,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    session.accessToken != "" && session.userID != "" && session.webviewRefreshToken != "" && session.webviewAccessToken != "" && session.webviewAcessTokenExpiresIn != "" -> {
                        logIn.visibility = View.GONE
                    }
                    else -> {
                        Toast.makeText(
                            applicationContext,
                            R.string.logInErrorUnknown,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            logIn.visibility = View.VISIBLE
        }
    }
}