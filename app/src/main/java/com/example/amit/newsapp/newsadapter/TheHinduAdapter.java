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
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.amit.newsapp.R;

import com.bumptech.glide.Glide;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduArticles;

import java.util.List;

public class TheHinduAdapter extends RecyclerView.Adapter<TheHinduAdapter.TheHinduViewHolder> {
    private List<TheHinduArticles> mTheHinduArticles;
    private Context mContext;
    public final String Tag = "TheHinduAdapter";

    public TheHinduAdapter(List<TheHinduArticles> aTheHinduArticles, Context aContext) {
        this.mTheHinduArticles = aTheHinduArticles;
        this.mContext = aContext;
    }

    @NonNull
    @Override
    public TheHinduViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View lView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.thehindu_layout,
                viewGroup, false);
        return new TheHinduViewHolder(lView);
    }

    @Override
    public void onBindViewHolder(@NonNull TheHinduViewHolder theHinduViewHolder, final int aPosition) {
        Glide.with(mContext)
                .load(mTheHinduArticles.get(aPosition).getUrlToImage())
                .centerCrop()
                .into(theHinduViewHolder.mImageView);
        theHinduViewHolder.mSourceName.setText(mTheHinduArticles.get(aPosition).getSource().getName());
        theHinduViewHolder.mTittle.setText(mTheHinduArticles.get(aPosition).getTitle());
        theHinduViewHolder.mNewsDiscription.setText(mTheHinduArticles.get(aPosition).getDescription());
        theHinduViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(mContext, android.R.style.ThemeOverlay_Material_ActionBar);
                dialog.setContentView(R.layout.news_api_webview);
                Toolbar toolbar = dialog.findViewById(R.id.news_toolbar);
                WebView webView = dialog.findViewById(R.id.web_view_page);
                webView.getSettings().setJavaScriptEnabled(true);
                webView.setWebViewClient(new WebViewClient());
                webView.loadUrl(mTheHinduArticles.get(aPosition).getUrl());
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
        return mTheHinduArticles.size();
    }

    public class TheHinduViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mSourceName, mTittle, mNewsDiscription;
        private LinearLayout mCardView;
        public TheHinduViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.hindu_image);
            mSourceName = (TextView) itemView.findViewById(R.id.news_source);
            mTittle = (TextView) itemView.findViewById(R.id.news_tittle);
            mCardView = itemView.findViewById(R.id.news_cardview);
            mNewsDiscription = (TextView) itemView.findViewById(R.id.news_discription);
        }
    }
}
