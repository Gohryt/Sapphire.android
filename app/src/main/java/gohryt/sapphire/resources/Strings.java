package gohryt.sapphire.resources;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Strings {
    public String applicationName;

    public String loginEnter;
    public String loginUsername;
    public String loginPassword;
    public String loginConfirm;

    public Strings(Context context) {
        applicationName = context.getString(R.string.application_name);

        loginEnter = context.getString(R.string.login_enter);
        loginUsername = context.getString(R.string.login_username);
        loginPassword = context.getString(R.string.login_password);
        loginConfirm = context.getString(R.string.login_password);
    }
}