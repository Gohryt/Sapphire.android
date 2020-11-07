package com.gohryt.sapphire

import android.annotation.SuppressLint
import android.app.ActivityManager
import android.app.ActivityManager.MemoryInfo
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

    @SuppressLint("HardwareIds")
    override fun onCreate(savedInstanceState: Bundle?) {
        val memoryInfo = MemoryInfo()
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(memoryInfo)
        Libgo.configureLibgo(Runtime.getRuntime().availableProcessors(), memoryInfo.totalMem)
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
        this.setTheme(R.style.Sapphire)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = navHostFragment.navController
        if (session.accessToken == "" || session.userID == "" || session.webviewRefreshToken == "" || session.webviewAccessToken == "" || session.webviewAcessTokenExpiresIn == "") {
            navController.navigate(R.id.action_fragmentUserprofile_to_fragmentAuth)
        }
    }
}