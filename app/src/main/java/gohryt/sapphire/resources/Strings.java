package gohryt.sapphire.resources;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Strings {
    String ApplicationName;

    String LoginEnter;
    String LoginUsername;
    String LoginPassword;
    String LoginConfirm;

    Strings(Context context) {
        ApplicationName = context.getString(R.string.application_name);

        LoginEnter = context.getString(R.string.login_enter);
        LoginUsername = context.getString(R.string.login_username);
        LoginPassword = context.getString(R.string.login_password);
        LoginConfirm = context.getString(R.string.login_password);
    }
}