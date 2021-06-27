package gohryt.sapphire.resources;

import android.content.Context;
import android.graphics.Typeface;

import androidx.core.content.res.ResourcesCompat;

import gohryt.sapphire.R;

public class Typefaces {
    public Typeface light;
    public Typeface lightItalic;

    public Typeface regular;
    public Typeface regularItalic;

    public Typeface medium;
    public Typeface mediumItalic;

    public Typeface bold;
    public Typeface boldItalic;

    public Typefaces(Context context) {
        light = ResourcesCompat.getFont(context, R.font.light);
        lightItalic = ResourcesCompat.getFont(context, R.font.light_italic);

        regular = ResourcesCompat.getFont(context, R.font.regular);
        regularItalic = ResourcesCompat.getFont(context, R.font.regular_italic);

        medium = ResourcesCompat.getFont(context, R.font.medium);
        mediumItalic = ResourcesCompat.getFont(context, R.font.medium_italic);

        bold = ResourcesCompat.getFont(context, R.font.bold);
        boldItalic = ResourcesCompat.getFont(context, R.font.bold_italic);
    }
}
