package gohryt.sapphire.resources;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Colors {
    int ForegroundMain;
    int ForegroundPoor;
    int ForegroundAccent;
    int BackgroundMain;
    int BackgroundActive;
    int BackgroundPoor;

    Colors(Context context) {
        ForegroundMain = ContextCompat.getColor(context, R.color.foregroundMain);
        ForegroundPoor = ContextCompat.getColor(context, R.color.foregroundPoor);
        ForegroundAccent = ContextCompat.getColor(context, R.color.foregroundAccent);
        BackgroundMain = ContextCompat.getColor(context, R.color.backgroundMain);
        BackgroundActive = ContextCompat.getColor(context, R.color.backgroundActive);
        BackgroundPoor = ContextCompat.getColor(context, R.color.backgroundPoor);
    }
}
