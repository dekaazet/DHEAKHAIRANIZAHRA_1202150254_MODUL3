package com.example.android.dheakhairanizahra_1202150254_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = (EditText) findViewById(R.id.input_username);
        password = (EditText) findViewById(R.id.input_password);
    }

    /*Method yang dipanggil saat Button Login ditekan*/
    public void Masuk(View view) {
        /*Memastikan username & password yang dimasukkan adalah benar*/
        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")){
            Toast.makeText(getApplicationContext(),"Login Berhasil!", Toast.LENGTH_SHORT).show();
            /*Membuat intent baru untuk pindah ke aktivitas selanjutnya*/
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(),"Login Gagal! Pastikan Username & Password Benar.", Toast.LENGTH_SHORT).show();
        }
    }
}
