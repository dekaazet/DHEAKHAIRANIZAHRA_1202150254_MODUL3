package com.example.android.dheakhairanizahra_1202150254_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    /*Durasi Splash Screen*/
    private static int splash_interval = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*Method ini dijalankan selesainya waktu interval splash screen*/

                /*Memulai aktivitas baru*/
                Intent i = new Intent(SplashScreen.this, Login.class);
                startActivity(i);

                /*Splashscreen selesai. Agar tidak dapat kembali ke splashscreen dengan tombol back*/
                finish();
            }
        }, splash_interval);
    }

}