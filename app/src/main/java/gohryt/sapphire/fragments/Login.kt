package gohryt.sapphire.fragments

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
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
        scroll.run {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT,
                1f
            )
            isFillViewport = true
        }

        val navigation = View(context)
        navigation.run {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 0f)
        }

        val line = LinearLayout(context)
        line.run {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
            )
            orientation = VERTICAL
        }

        val status = View(context)
        status.run {
            layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, 0, 0f)
        }

        val frame = FrameLayout(context)
        frame.run {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT,
                1f
            )
            setPadding(8)
        }

        val login = LinearLayout(context)
        login.run {
            layoutParams = FrameLayout.LayoutParams(
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
            (layoutParams as FrameLayout.LayoutParams).setMargins(8)
            setPadding(8)
            orientation = VERTICAL
            Shape(Activity.colors!!.backgroundMain, 16f)
        }

        val loginEnter = TextView(context)
        loginEnter.run {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                0f
            )
            (layoutParams as LayoutParams).setMargins(8)
            (layoutParams as LayoutParams).gravity = Gravity.START
            text = Activity.strings!!.loginEnter
            typeface = Activity.typefaces!!.bold
            setTextColor(Activity.colors!!.foregroundMain)
            textSize = 16f
        }

        val loginUsername = EditText(context)
        loginUsername.run {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT,
                0f
            )
            (layoutParams as LayoutParams).setMargins(8)
            (layoutParams as LayoutParams).gravity = Gravity.CENTER
            setPadding(16)
            text.insert(0, Activity.storage.get("Username"))
            hint = Activity.strings!!.loginUsername
            inputType = InputType.TYPE_CLASS_TEXT
            typeface = Activity.typefaces!!.regular
            setTextColor(Activity.colors!!.foregroundMain)
            setHintTextColor(Activity.colors!!.foregroundPoor)
            textSize = 14f
            background = Shape(Activity.colors!!.backgroundPoor, 16f)
        }

        val loginPassword = EditText(context)
        loginPassword.run {
            layoutParams = LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT,
                0f
            )
            (layoutParams as LayoutParams).setMargins(8)
            (layoutParams as LayoutParams).gravity = Gravity.CENTER
            setPadding(16)
            text.insert(0, Activity.storage.get("Password"))
            hint = Activity.strings!!.loginPassword
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            typeface = Activity.typefaces!!.regular
            setTextColor(Activity.colors!!.foregroundMain)
            setHintTextColor(Activity.colors!!.foregroundPoor)
            textSize = 14f
            background = Shape(Activity.colors!!.backgroundPoor, 16f)
        }

        val loginConfirm = TextView(context)
        loginConfirm.run {
            layoutParams = LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT,
                0f
            )
            (layoutParams as LayoutParams).setMargins(8)
            (layoutParams as LayoutParams).gravity = Gravity.END
            setPadding(16)
            text = Activity.strings!!.loginConfirm
            typeface = Activity.typefaces!!.regular
            setTextColor(Activity.colors!!.foregroundAccent)
            textSize = 14f
            background = Shape(Activity.colors!!.backgroundAccent, 16f)
        }

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