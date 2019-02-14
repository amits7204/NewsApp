package com.example.amit.newsapp.newsadapter;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, final int aPosition) {
        Glide.with(mContext)
                .load(mNewsArticlesList.get(aPosition).getUrlToImage())
                .centerCrop()
                .into(newsViewHolder.mNewsImage);

        newsViewHolder.mNewsTittle.setText(mNewsArticlesList.get(aPosition).getTitle());
        newsViewHolder.mNewsSource.setText(mNewsArticlesList.get(aPosition).getSource().getName());
        newsViewHolder.mIndiaNewsDiscription.setText(mNewsArticlesList.get(aPosition).getDescription());
        newsViewHolder.mIndianNewsCardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(mContext, android.R.style.ThemeOverlay_Material_ActionBar);
                dialog.setContentView(R.layout.news_api_webview);
                Toolbar toolbar = dialog.findViewById(R.id.news_toolbar);
                WebView webView = dialog.findViewById(R.id.web_view_page);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(mNewsArticlesList.get(aPosition).getUrl());
                webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                webView.getSettings().setAppCacheEnabled(false);
                toolbar.setTitle("@News Stuff");
                toolbar.setLogo(R.drawable.news);
                dialog.setCancelable(true);
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsArticlesList.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mNewsImage;
        public LinearLayout mIndianNewsCardview;
        public TextView mNewsTittle, mNewsSource, mIndiaNewsDiscription;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mNewsImage = (ImageView) itemView.findViewById(R.id.news_image);
            mNewsTittle = (TextView) itemView.findViewById(R.id.news_tittle);
            mNewsSource = (TextView) itemView.findViewById(R.id.news_source);
            mIndiaNewsDiscription = (TextView) itemView.findViewById(R.id.news_discription);
            mIndianNewsCardview = itemView.findViewById(R.id.news_cardview);

        }
    }
}
