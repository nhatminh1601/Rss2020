package com.example.rss.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rss.R;
import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    ArrayList<News> arr;
    private OnItemClickListener onItemClickListener;

    public MyAdapter(ArrayList<News> arr, OnItemClickListener onItemClickListener) {
        this.arr = arr;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getDataBind(arr.get(position));
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imgBg;
        LinearLayout linearLayout;
        News news;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            imgBg = itemView.findViewById(R.id.imgBg);
            linearLayout = itemView.findViewById(R.id.liner);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(news);
                }
            });
        }
        private void getDataBind(News news){
            this.news=news;
            tvTitle.setText(news.getName());
            Glide.with(imgBg.getContext()).load(news.getUrl()).into(imgBg);
            Log.d("TAG", "getData: "+news.toString());
        }
    }

}
