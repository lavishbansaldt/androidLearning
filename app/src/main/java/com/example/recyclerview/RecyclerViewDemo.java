package com.example.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlearning.R;

public class RecyclerViewDemo extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private String[] My_Dataset= {"Lavish", "Dev", "Vivek", "Ujjwal", "Iqbal", "Vijay", "Hemant", "Gaurav"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        recyclerView = findViewById(R.id.my_recycler_view);


        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        adapter= new RecyclerViewDemoMyAdapter(My_Dataset);
        recyclerView.setAdapter(adapter);

    }
}