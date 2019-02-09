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
    public void onBindViewHolder(@NonNull TheHinduViewHolder theHinduViewHolder, int aPosition) {
        Glide.with(mContext)
                .load(mTheHinduArticles.get(aPosition).getUrlToImage())
                .centerCrop()
                .into(theHinduViewHolder.mImageView);
        theHinduViewHolder.mSourceName.setText(mTheHinduArticles.get(aPosition).getSource().getName());
        theHinduViewHolder.mTittle.setText(mTheHinduArticles.get(aPosition).getTitle());
    }

    @Override
    public int getItemCount() {
        return mTheHinduArticles.size();
    }

    public class TheHinduViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mSourceName, mTittle;
        public TheHinduViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.hindu_image);
            mSourceName = (TextView) itemView.findViewById(R.id.news_source);
            mTittle = (TextView) itemView.findViewById(R.id.news_tittle);
        }
    }
}
