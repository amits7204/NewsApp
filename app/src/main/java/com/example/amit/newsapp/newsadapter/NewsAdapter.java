package com.example.amit.newsapp.newsadapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.amit.newsapp.R;
import com.bumptech.glide.Glide;
import com.example.amit.newsapp.pojoclassofnewsapi.Articles;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    public List<Articles> mNewsArticlesList;
    public Context mContext;

    public NewsAdapter(List<Articles> mNewsRootList, Context aContext) {
        this.mNewsArticlesList = mNewsRootList;
        this.mContext = aContext;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View lView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.indian_layout, viewGroup, false);
        return new NewsViewHolder(lView);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int aPosition) {
        Glide.with(mContext)
                .load(mNewsArticlesList.get(aPosition).getUrlToImage())
                .centerCrop()
                .into(newsViewHolder.mNewsImage);

        newsViewHolder.mNewsTittle.setText(mNewsArticlesList.get(aPosition).getTitle());
        newsViewHolder.mNewsSource.setText(mNewsArticlesList.get(aPosition).getSource().getName());
        newsViewHolder.mIndiaNewsDiscription.setText(mNewsArticlesList.get(aPosition).getDescription());
    }

    @Override
    public int getItemCount() {
        return mNewsArticlesList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mNewsImage;
        public TextView mNewsTittle, mNewsSource, mIndiaNewsDiscription;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mNewsImage = (ImageView) itemView.findViewById(R.id.news_image);
            mNewsTittle = (TextView) itemView.findViewById(R.id.news_tittle);
            mNewsSource = (TextView) itemView.findViewById(R.id.news_source);
            mIndiaNewsDiscription = (TextView) itemView.findViewById(R.id.news_discription);

        }
    }
}
