package gohryt.sapphire

import android.app.ActivityManager
import android.content.res.Resources
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.setContent
import gohryt.sapphire.fragments.Auth
import gohryt.sapphire.fragments.News
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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val memoryInfo = ActivityManager.MemoryInfo()
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
            Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID),
            android.os.Build.VERSION.SDK_INT,
            Resources.getSystem().displayMetrics.heightPixels,
            Resources.getSystem().displayMetrics.widthPixels
        )
        session = Libgo.setSession()
        properties = Libgo.setProperties()
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        if (session.accessToken == "" || session.userID == "" || session.webviewRefreshToken == "" || session.webviewAccessToken == "" || session.webviewAcessTokenExpiresIn == "") {
            setContent {
                Auth(
                    activity = this
                )
            }
        } else {
            setContent {
                News()
            }
        }
    }

    override fun onStop() {
        super.onStop()
        Libgo.gc()
        System.gc()
    }
}