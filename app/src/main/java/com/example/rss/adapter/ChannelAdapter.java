package com.example.rss.adapter;

import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rss.R;
import com.example.rss.interfaces.OnItemClickListener;
import com.example.rss.object.News;

import java.util.ArrayList;

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.MyViewHolder>{
    ArrayList<News> arr;
    private OnItemClickListener onItemClickListener;

    public ChannelAdapter(ArrayList<News> arr, OnItemClickListener onItemClickListener) {
        this.arr = arr;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ChannelAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_channel, parent, false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelAdapter.MyViewHolder holder, int position) {
        holder.getDataBind(arr.get(position));
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        News news;
        TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(news);
                }
            });
        }
        private void getDataBind(News news){
            this.news=news;
            if(news.getContent()!=null){
                title.setTextAlignment(itemView.TEXT_ALIGNMENT_VIEW_START);
                title.setTypeface(null, Typeface.ITALIC);
            }
            else {
                title.setTypeface(null, Typeface.BOLD);
            }
            title.setText(news.getName());
        }
    }
}
