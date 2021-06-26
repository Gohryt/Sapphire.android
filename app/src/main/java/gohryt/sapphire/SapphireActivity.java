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

@RequiresApi(Build.VERSION_CODES.R)
public class SapphireActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TextView view = new TextView(this);
        view.setText(R.string.application_name);

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