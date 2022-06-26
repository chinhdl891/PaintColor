package com.example.color;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Bitmap bitmap;
    LinearLayout linearLayout;
    private static final String TAG = "aaa";
    private static final String TAG1 = "aaaa";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imv_main_color);
        textView = findViewById(R.id.tv_main_color);
        linearLayout = findViewById(R.id.lnl_main_bg);
        ReDesign.resizeImage(imageView, 300, 300);
        imageView.setDrawingCacheEnabled(true);
        imageView.buildDrawingCache(true);

        imageView.setOnTouchListener((view, motionEvent) -> {
            bitmap = imageView.getDrawingCache();
            int[] location = new int[2];
            imageView.getLocationOnScreen(location);
            int x = location[0];
            int y = location[1];

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                if (motionEvent.getY() > 0 && motionEvent.getX() > 0 && motionEvent.getX() < 300 && motionEvent.getY() < 300) {
                    Log.d(TAG, "onCreate: " + motionEvent.getX());
                    int pixel = bitmap.getPixel((int) motionEvent.getX(), (int) motionEvent.getY());
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);
                    String hex = "#" + Integer.toHexString(pixel);
                    textView.setText(hex);
                    linearLayout.setBackgroundColor(Color.rgb(r, g, b));
                }

            }
            return true;
        });
    }

}