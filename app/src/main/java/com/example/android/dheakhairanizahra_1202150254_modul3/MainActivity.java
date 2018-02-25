package com.example.android.dheakhairanizahra_1202150254_modul3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> daftar_judul = new LinkedList<>();
    private final LinkedList<String> daftar_subjudul = new LinkedList<>();
    private final LinkedList<Integer> daftar_background = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setData();

        /*Memperoleh handle untuk Recycler View nya*/
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        /*Membuat Adapter serta mensuplai data untuk ditampilkan*/
        mAdapter = new ListAdapter(this, daftar_judul, daftar_subjudul, daftar_background);
        /*Menghubungkan Adapter dengan Recycler View*/
        mRecyclerView.setAdapter(mAdapter);
        /*Menetapkan layout manager untuk Recycler View*/
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count); //grid_column_count ada di integers.xml untuk menentukan jumlah kolom untuk grid
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
    }

    /*Untuk memasukkan data dalam array ke recycler view*/
    private void setData(){
        //Array berisikan data-data merek minumannya
        String merek[] = {"Ades","Amidis", "Aqua", "Cleo", "Club", "Equil", "Evian", "Leminerale", "Nestle", "Pristine", "Vit"};

        //Menset judul dan subjudul card view
        for (String brand: merek) {
            daftar_judul.addLast(brand);
            daftar_subjudul.addLast("Ini adalah air minum merek " + brand);
        }

        //Menset gambar background card view
        daftar_background.addLast(R.drawable.ades);
        daftar_background.addLast(R.drawable.amidis);
        daftar_background.addLast(R.drawable.aqua);
        daftar_background.addLast(R.drawable.cleo);
        daftar_background.addLast(R.drawable.club);
        daftar_background.addLast(R.drawable.equil);
        daftar_background.addLast(R.drawable.evian);
        daftar_background.addLast(R.drawable.leminerale);
        daftar_background.addLast(R.drawable.nestle);
        daftar_background.addLast(R.drawable.pristine);
        daftar_background.addLast(R.drawable.vit);
    }
}
