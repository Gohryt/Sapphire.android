package gohryt.sapphire.fragments

import android.animation.ValueAnimator
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.*
import androidx.core.widget.addTextChangedListener
import gohryt.sapphire.Activity
import gohryt.sapphire.animations.Size
import gohryt.sapphire.elements.*

@RequiresApi(Build.VERSION_CODES.R)
class Login(context: Context) : LinearLayout(context) {
    init {
        this.orientation = VERTICAL

        val scroll = ScrollView(context)
        val scrollLayoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT,
            1f
        )
        scroll.isFillViewport = true
        scroll.layoutParams = scrollLayoutParams

        val navigation = View(context)
        val navigationLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 0f)
        navigation.layoutParams = navigationLayoutParams

        val line = LinearLayout(context)
        val lineLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
        line.orientation = VERTICAL
        line.layoutParams = lineLayoutParams

        val status = View(context)
        val statusLayoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 0f)
        status.layoutParams = statusLayoutParams

        val frame = FrameLayout(context)
        val frameLayoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.MATCH_PARENT,
            1f
        )
        frame.setPadding(8)
        frame.layoutParams = frameLayoutParams

        val login = LinearLayout(context)
        val loginLayoutParams = FrameLayout.LayoutParams(
            when {
                (context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE && Activity.metrics!!.widthPixels >= 720) -> Activity.metrics!!.widthPixels * 0.4
                (context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE && Activity.metrics!!.widthPixels >= 480) -> Activity.metrics!!.widthPixels * 0.6
                (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT && Activity.metrics!!.widthPixels >= 720) -> Activity.metrics!!.widthPixels * 0.5
                (context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT && Activity.metrics!!.widthPixels >= 480) -> Activity.metrics!!.widthPixels * 0.7
                else -> this.width * 0.9
            }.toInt(),
            FrameLayout.LayoutParams.WRAP_CONTENT,
            Gravity.CENTER
        )
        loginLayoutParams.setMargins(8)
        login.setPadding(8)
        login.orientation = VERTICAL
        login.background = Shape(Activity.colors!!.backgroundMain, 16f)
        login.layoutParams = loginLayoutParams

        val loginEnter = TextView(context)
        val loginEnterLayoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT,
            0f
        )
        loginEnterLayoutParams.setMargins(8)
        loginEnterLayoutParams.gravity = Gravity.START
        loginEnter.text = Activity.strings!!.loginEnter
        loginEnter.typeface = Activity.typefaces!!.bold
        loginEnter.setTextColor(Activity.colors!!.foregroundMain)
        loginEnter.textSize = 16f
        loginEnter.layoutParams = loginEnterLayoutParams

        val loginUsername = EditText(context)
        val loginUsernameLayoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT,
            0f
        )
        loginUsernameLayoutParams.setMargins(8)
        loginUsernameLayoutParams.gravity = Gravity.CENTER
        loginUsername.setPadding(16)
        loginUsername.text.insert(0, Activity.storage.get("Username"))
        loginUsername.hint = Activity.strings!!.loginUsername
        loginUsername.inputType = InputType.TYPE_CLASS_TEXT
        loginUsername.typeface = Activity.typefaces!!.regular
        loginUsername.setTextColor(Activity.colors!!.foregroundMain)
        loginUsername.setHintTextColor(Activity.colors!!.foregroundPoor)
        loginUsername.textSize = 14f
        loginUsername.background = Shape(Activity.colors!!.backgroundPoor, 16f)
        loginUsername.layoutParams = loginUsernameLayoutParams

        val loginPassword = EditText(context)
        val loginPasswordLayoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT,
            0f
        )
        loginPasswordLayoutParams.setMargins(8)
        loginPasswordLayoutParams.gravity = Gravity.CENTER
        loginPassword.setPadding(16)
        loginPassword.text.insert(0, Activity.storage.get("Password"))
        loginPassword.hint = Activity.strings!!.loginPassword
        loginPassword.inputType =
            InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        loginPassword.typeface = Activity.typefaces!!.regular
        loginPassword.setTextColor(Activity.colors!!.foregroundMain)
        loginPassword.setHintTextColor(Activity.colors!!.foregroundPoor)
        loginPassword.textSize = 14f
        loginPassword.background = Shape(Activity.colors!!.backgroundPoor, 16f)
        loginPassword.layoutParams = loginPasswordLayoutParams

        val loginConfirm = TextView(context)
        val loginConfirmLayoutParams = LayoutParams(
            LayoutParams.WRAP_CONTENT,
            LayoutParams.WRAP_CONTENT,
            0f
        )
        loginConfirmLayoutParams.setMargins(8)
        loginConfirmLayoutParams.gravity = Gravity.END
        loginConfirm.setPadding(16)
        loginConfirm.text = Activity.strings!!.loginConfirm
        loginConfirm.typeface = Activity.typefaces!!.regular
        loginConfirm.setTextColor(Activity.colors!!.foregroundAccent)
        loginConfirm.textSize = 14f
        loginConfirm.background = Shape(Activity.colors!!.backgroundAccent, 16f)
        loginConfirm.layoutParams = loginConfirmLayoutParams

        login.addView(loginEnter)
        login.addView(loginUsername)
        login.addView(loginPassword)
        login.addView(loginConfirm)

        frame.addView(login)

        line.addView(status)
        line.addView(frame)

        scroll.addView(line)

        this.addView(scroll)
        this.addView(navigation)

        loginUsername.addTextChangedListener {
            Activity.storage.set("Username", loginUsername.text.toString())
        }
        loginPassword.addTextChangedListener {
            Activity.storage.set("Password", loginPassword.text.toString())
        }

        loginConfirm.setOnClickListener {
            val result = Activity.session.login()
            if (result == "") {
                Activity.navigator!!.move(Activity.core.routes.news)
            } else {
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(navigation) { view, insets ->
            val n = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
            val i = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            Size.setHeight(view, view.height, if (i > 0) i else n, 300L)
            return@setOnApplyWindowInsetsListener insets
        }
        ViewCompat.setOnApplyWindowInsetsListener(status) { view, insets ->
            val s = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            Size.setHeight(view, view.height, s, 300L)
            return@setOnApplyWindowInsetsListener insets
        }
    }
}