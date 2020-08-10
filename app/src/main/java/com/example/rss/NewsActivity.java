package com.example.rss;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;
import com.example.rss.xml.ReadXml;

public class NewsActivity extends AppCompatActivity implements OnItemClickListener {
    News news;
    ActionBar actionBar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        news = (News) intent.getSerializableExtra("news");
        String title= intent.getStringExtra("title");
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(title+" - "+ news.getName().toUpperCase());
        recyclerView = findViewById(R.id.recyclerView);
        if(checkInternet()){
            ReadXml readXml = new ReadXml(this, news, recyclerView);
            readXml.execute();
        }
        else {
            Toast.makeText(this,"Please open the network!",Toast.LENGTH_LONG).show();
        }

    }

    private Boolean checkInternet() {
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public void onItemClick(News news) {
        showNiceDialogBox(news);
    }

    private void showNiceDialogBox(News news) {
        String title = news.getName();
        String description = news.getContent();
        if (title.toLowerCase().equals(description.toLowerCase())) {
            description = "";
        }
        try {
            final Uri storyLink = Uri.parse(news.getUrl());
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(this);
            myBuilder.setIcon(R.drawable.ic_baseline_rss_feed_24).setTitle(title)
                    .setMessage(title + "\n\n " + Html.fromHtml(description) + "\n")
                    .setPositiveButton("Close", null).setNegativeButton("More", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichOne) {
                    Intent browser = new Intent(Intent.ACTION_VIEW, storyLink);
                    startActivity(browser);
                }
            })//setNegativeButton
                    .show();
        } catch (Exception e) {
            Log.e("Error DialogBox", e.getMessage());
        }
    }
}