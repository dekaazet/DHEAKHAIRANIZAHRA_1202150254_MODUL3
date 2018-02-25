package com.example.android.dheakhairanizahra_1202150254_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.WordViewHolder> {

    private final LinkedList<String> mDaftarJudul;
    private final LinkedList<String> mDaftarSubjudul;
    private final LinkedList<Integer> mDaftarBackground;
    private LayoutInflater mInflater;

    public ListAdapter(Context context, LinkedList<String> daftar_judul, LinkedList<String> daftar_subjudul, LinkedList<Integer> daftar_background) {
        mInflater = LayoutInflater.from(context);
        this.mDaftarJudul = daftar_judul;
        this.mDaftarSubjudul = daftar_subjudul;
        this.mDaftarBackground = daftar_background;
    }

    /*Untuk membuat view*/
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    /*Untuk menghubungkan data dengan view*/
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        final String mCurrentTitle = mDaftarJudul.get(position);
        final String mCurrentSubTitle = mDaftarSubjudul.get(position);
        final Integer mCurrentBackground = mDaftarBackground.get(position);
        holder.itemjudul.setText(mCurrentTitle);
        holder.itemsubjudul.setText(mCurrentSubTitle);
        holder.linearLayout.setBackgroundResource(mCurrentBackground);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Detail.class);
                intent.putExtra("Title",mCurrentTitle);
                intent.putExtra("Background",mCurrentBackground);
                view.getContext().startActivity(intent);
            }
        });
    }

    /*Menentukan ukuran atau jumlah data yang ditampilkan di recycler view*/
    @Override
    public int getItemCount() {

        return mDaftarJudul.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {
        public final TextView itemjudul, itemsubjudul;
        public final LinearLayout linearLayout;
        final ListAdapter mAdapter;
        public WordViewHolder(View itemView, ListAdapter adapter) {
            super(itemView);
            itemjudul = (TextView) itemView.findViewById(R.id.judul);
            itemsubjudul = (TextView) itemView.findViewById(R.id.subJudul);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.background);
            this.mAdapter = adapter;
        }
    }
}
