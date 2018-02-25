package com.example.android.dheakhairanizahra_1202150254_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail extends AppCompatActivity {

    TextView judul, liter;
    ImageView gambar, gambar_baterai;
    private int liters = 0; //Menetapkan nilai default liters adalah 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        String Title = intent.getStringExtra("Title");
        Integer Background = intent.getIntExtra("Background",0);

        judul = (TextView)findViewById(R.id.judulDetail);
        liter = (TextView)findViewById(R.id.liter);
        gambar = (ImageView)findViewById(R.id.fotoDetail);
        gambar_baterai = (ImageView)findViewById(R.id.baterai);

        judul.setText(Title);
        Bottle();
        gambar.setImageResource(Background);
    }

    /*Method yang dipanggil saat button plus ditekan*/
    public void onPlus(View view) {
        liters++;   //Menambahkan nilai variabel liters
        Bottle();   //Menjalankan method Bottle yang berisi kondisi sesuai dengan variabel liters
    }

    /*Method yang dipanggil saat button minus ditekan*/
    public void onMin(View view) {
        liters--;
        Bottle();
    }

    /*Method yang beguna untuk menset teks dan gambar yang akan ditampilkan sesuai kondisi*/
    public void Bottle(){
        if (liters <= 0 ){
            liter.setText("1L");
            gambar_baterai.setImageResource(R.drawable.ic_battery_20);
            Toast.makeText(this,"Air sedikit",Toast.LENGTH_SHORT).show();
        }else if (liters == 1){
            liter.setText("2L");
            gambar_baterai.setImageResource(R.drawable.ic_battery_50);
        }else if(liters == 2){
            liter.setText("3L");
            gambar_baterai.setImageResource(R.drawable.ic_battery_80);
        }else{
            liter.setText("4L");
            gambar_baterai.setImageResource(R.drawable.ic_battery_full);
            Toast.makeText(this,"Air penuh",Toast.LENGTH_SHORT).show();
        }
    }
}
