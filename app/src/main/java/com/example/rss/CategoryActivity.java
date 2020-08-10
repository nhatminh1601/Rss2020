package com.example.rss;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.rss.object.News;

public class CategoryActivity extends AppCompatActivity {
    Bundle news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();
        news = intent.getBundleExtra("news");
        Log.d("TAGd", "onCreate: "+news);
    }
}