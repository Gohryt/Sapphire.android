package gohryt.sapphire.resources;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Errors {
    String AddressNotFound;

    Errors(Context context) {
        AddressNotFound = context.getString(R.string.error_addressNotFound);
    }
}