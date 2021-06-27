package gohryt.sapphire.resources;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Colors {
    public int foregroundMain;
    public int foregroundPoor;
    public int foregroundAccent;

    public int backgroundMain;
    public int backgroundActive;
    public int backgroundPoor;

    public Colors(Context context) {
        foregroundMain = ContextCompat.getColor(context, R.color.foregroundMain);
        foregroundPoor = ContextCompat.getColor(context, R.color.foregroundPoor);
        foregroundAccent = ContextCompat.getColor(context, R.color.foregroundAccent);

        backgroundMain = ContextCompat.getColor(context, R.color.backgroundMain);
        backgroundActive = ContextCompat.getColor(context, R.color.backgroundActive);
        backgroundPoor = ContextCompat.getColor(context, R.color.backgroundPoor);
    }
}
