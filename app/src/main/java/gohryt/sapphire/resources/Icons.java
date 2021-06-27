package gohryt.sapphire.resources;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import gohryt.sapphire.R;

@RequiresApi(Build.VERSION_CODES.R)
public class Icons {
    public Drawable like;

    public Icons(Context context) {
        like = ContextCompat.getDrawable(context, R.drawable.icon_like);
    }
}