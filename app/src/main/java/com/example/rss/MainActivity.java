package com.example.rss;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.rss.adapter.MyAdapter;
import com.example.rss.data.Data;
import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity  implements OnItemClickListener {
    MyAdapter myAdapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Data data;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        layoutManager= new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        data=new Data();
        myAdapter=new MyAdapter((ArrayList<News>) data.LoadData(),this);

        recyclerView.setAdapter(myAdapter);
        recyclerView.setHasFixedSize(true);
        actionBar=getSupportActionBar();
        actionBar.setTitle("NEWS APP");
    }

    @Override
    public void onItemClick(News news) {
        Intent intent= new Intent(MainActivity.this,CategoryActivity.class);
        intent.putExtra("news",news);
        startActivity(intent);
    }
}