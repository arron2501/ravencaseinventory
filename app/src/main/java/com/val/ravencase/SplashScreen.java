package com.val.ravencase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    //Set waktu load splash screen 4 detik
    private int loadSplash = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Setelah loading akan diarahkan ke activity lain
                startActivity(new Intent(getApplicationContext(), Welcome.class));
                finish();
            }
        }, loadSplash);
    }
}