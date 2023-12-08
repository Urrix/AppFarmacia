package com.example.project160.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.project160.Adapter.TrendsAdapter;
import com.example.project160.Domain.TrendsDomain;
import com.example.project160.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTrendList;
    private RecyclerView recyclerViewTrends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        BottomNavigation();
    }

    private void BottomNavigation() {
        LinearLayout profileBtn=findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ProfileActivity.class)));
    }

    private void initRecyclerView() {
        ArrayList<TrendsDomain> items = new ArrayList<>();
        items.add(new TrendsDomain("Farmacia Gudalajara", "Siempre ahorrando, siempre contigo", "trends"));
        items.add(new TrendsDomain("Farmacia del Ahorro", "Te queremos bien", "trends2"));
        items.add(new TrendsDomain("Farmacia Similares", "Lo mismo pero más barato", "trends3"));

        recyclerViewTrends = findViewById(R.id.view1);
        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterTrendList = new TrendsAdapter(items);
        recyclerViewTrends.setAdapter(adapterTrendList);
    }
}