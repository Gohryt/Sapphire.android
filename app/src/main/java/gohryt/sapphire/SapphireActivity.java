package gohryt.sapphire;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;

import gohryt.sapphire.resources.Colors;
import gohryt.sapphire.resources.Errors;
import gohryt.sapphire.resources.Icons;
import gohryt.sapphire.resources.Strings;

@RequiresApi(Build.VERSION_CODES.R)
public class SapphireActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Colors colors = new Colors(this);
        Errors errors = new Errors(this);
        Icons icons = new Icons(this);
        Strings strings = new Strings(this);

        TextView view = new TextView(this);
        view.setText(strings.applicationName);
        view.setTextColor(colors.foregroundAccent);

        super.setTheme(R.style.Theme_Sapphire);
        super.onCreate(savedInstanceState);
        super.setContentView(view);
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