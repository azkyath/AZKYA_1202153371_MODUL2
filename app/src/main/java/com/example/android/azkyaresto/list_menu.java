package com.example.android.azkyaresto;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;


public class list_menu extends AppCompatActivity {

    private final LinkedList<String> makanan = new LinkedList<>();
    private final LinkedList<Integer> harga = new LinkedList<>();
    private final LinkedList<Integer> pict = new LinkedList<>();
    private int mCount = 0;

    private RecyclerView mRecyclerView;
    private menu_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_menu);
        dummiesData();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new menu_adapter(this, makanan, harga, pict);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void dummiesData() {
        for (int i = 0;i < 3; i++){
            makanan.add("Boston Specialty Pasta");
            makanan.add("Garlic Escargot");
            makanan.add("Grandma Lasagna");
            makanan.add("Beef Raviolli");
            makanan.add("Sweet Tiramisu");

            harga.add(50000);
            harga.add(90000);
            harga.add(60000);
            harga.add(60000);
            harga.add(40000);

            pict.add(R.drawable.boston);
            pict.add(R.drawable.escargot);
            pict.add(R.drawable.lasagna);
            pict.add(R.drawable.ravioli);
            pict.add(R.drawable.tiramisu);
        }
    }
}
