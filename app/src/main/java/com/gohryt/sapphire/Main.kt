package com.gohryt.sapphire

import android.os.Bundle
import android.provider.Settings.Secure
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import libgo.Libgo
import libgo.PropertiesStruct
import libgo.SessionStruct
import libgo.VariablesStruct
import java.util.*

class Main : AppCompatActivity() {
    companion object {
        lateinit var variables: VariablesStruct
        lateinit var session: SessionStruct
        lateinit var properties: PropertiesStruct
        lateinit var navController: NavController
    }
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
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController
        if (session.accessToken == "" || session.userID == "" || session.webviewRefreshToken == "" || session.webviewAccessToken == "" || session.webviewAcessTokenExpiresIn == "") {
            navController.navigate(R.id.fragmentAuth)
        }
    }
}