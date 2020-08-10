package com.example.rss;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.rss.adapter.ChannelAdapter;
import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements OnItemClickListener {
    News news;
    ActionBar actionBar;
    RecyclerView recyclerView;
    ChannelAdapter channelAdapter;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();
        news = (News) intent.getSerializableExtra("news");
        actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        if(news.getName()!=null){
            actionBar.setTitle(news.getName());
            title=news.getName();
        }
        recyclerView=findViewById(R.id.recyclerView);
        if(news.getSubName().size()>0){
            channelAdapter= new ChannelAdapter((ArrayList<News>) news.getSubName(),this);
            recyclerView.setAdapter(channelAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemClick(News news) {
        Intent intent=new Intent(CategoryActivity.this,NewsActivity.class);
        intent.putExtra("news",news);
        intent.putExtra("title",title);
        startActivity(intent);
    }
}