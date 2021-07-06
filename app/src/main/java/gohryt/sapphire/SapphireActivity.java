package gohryt.sapphire;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import gohryt.sapphire.resources.Colors;
import gohryt.sapphire.resources.Errors;
import gohryt.sapphire.resources.Icons;
import gohryt.sapphire.resources.Strings;
import gohryt.sapphire.resources.Typefaces;

@RequiresApi(Build.VERSION_CODES.R)
public class SapphireActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Colors colors = new Colors(this);
        Errors errors = new Errors(this);
        Icons icons = new Icons(this);
        Strings strings = new Strings(this);
        Typefaces typefaces = new Typefaces(this);

        TextView view = new TextView(this);
        view.setText(strings.applicationName);
        view.setTextColor(colors.foregroundMain);
        view.setTypeface(typefaces.bold);
        view.setGravity(Gravity.CENTER);
        view.setTextSize(24f);

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
        );

        FrameLayout layout = new FrameLayout(this);
        layout.setLayoutParams(params);
        layout.addView(view);

        super.setTheme(R.style.Theme_Sapphire);
        super.onCreate(savedInstanceState);
        super.setContentView(layout);
    }

    @Override
    public void onAttachedToWindow() {
        Window window = super.getWindow();

        window.setStatusBarColor(Color.TRANSPARENT);
        window.setNavigationBarColor(Color.TRANSPARENT);
        WindowCompat.setDecorFitsSystemWindows(window, false);

        super.onAttachedToWindow();
    }

    @Override
    public void onPause() {
        System.gc();

        super.onPause();
    }
}