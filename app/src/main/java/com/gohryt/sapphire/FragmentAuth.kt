package com.gohryt.sapphire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_auth.view.*
import libgo.Libgo

class FragmentAuth : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val realView = inflater.inflate(R.layout.fragment_auth, container, false)
        realView.auth_submit.setOnClickListener {
            val auth =
                Libgo.auth(realView.auth_username.text.toString(), realView.auth_password.text.toString())
            when {
                auth.error == "invalid_client" && auth.errorType == "username_or_password_is_incorrect" -> {
                    Toast.makeText(
                        activity,
                        R.string.authErrorIncorrect,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                auth.error == "need_validation" && auth.validationSid != "" && auth.redirectURI != "" -> {
                    Toast.makeText(
                        activity,
                        R.string.authError2fa,
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Main.session.accessToken != "" && Main.session.userID != "" && Main.session.webviewRefreshToken != "" && Main.session.webviewAccessToken != "" && Main.session.webviewAcessTokenExpiresIn != "" -> {
                    realView.auth_base.visibility = View.GONE
                    Main.navController.navigate(R.id.fragmentUserprofile)
                }
                else -> {
                    Toast.makeText(
                        activity,
                        R.string.authErrorUnknown,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        realView.auth_base.visibility = View.VISIBLE
        return realView
    }
}