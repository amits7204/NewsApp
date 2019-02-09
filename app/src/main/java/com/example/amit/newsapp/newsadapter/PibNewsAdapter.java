package com.example.amit.newsapp.newsadapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.amit.newsapp.R;

import com.example.amit.newsapp.pojoclassofnewsapi.Articles;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduArticles;

import java.util.List;

public class PibNewsAdapter extends RecyclerView.Adapter<PibNewsAdapter.PibViewHolder> {
    public List<Articles> mNewsArticlesList;
    public Context mContext;

    public PibNewsAdapter(List<Articles> mNewsRootList, Context aContext) {
        this.mNewsArticlesList = mNewsRootList;
        this.mContext = aContext;
    }

    @NonNull
    @Override
    public PibViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View lView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.pib_news_layout, viewGroup, false);
        return new PibViewHolder(lView);
    }

    @Override
    public void onBindViewHolder(@NonNull PibViewHolder newsViewHolder, int aPosition) {

        /*Bitmap mbitmap = ((BitmapDrawable) mContext.getResources().getDrawable(R.drawable.delhiindia)).getBitmap();
        Bitmap imageRounded = Bitmap.createBitmap(mbitmap.getWidth(), mbitmap.getHeight(), mbitmap.getConfig());
        Canvas canvas = new Canvas(imageRounded);
        Paint mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setShader(new BitmapShader(mbitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        Log.w("PibNewsAdapter","Width and Height: "+mbitmap.getWidth()+ " " +mbitmap.getHeight());
        canvas.drawRoundRect((new RectF(0, 0,30, 30)), 30, 30, mpaint);// Round Image Corner 100 100 100 100
        newsViewHolder.mNewsImage.setImageBitmap(imageRounded);*/
        newsViewHolder.mNewsTittle.setText(mNewsArticlesList.get(aPosition).getTitle());
        newsViewHolder.mNewsSource.setText(mNewsArticlesList.get(aPosition).getSource().getName());
        newsViewHolder.mNewsDiscription.setText(mNewsArticlesList.get(aPosition).getDescription());
    }

    @Override
    public int getItemCount() {
        return mNewsArticlesList.size();
    }

    public class PibViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView mNewsImage;
        public TextView mNewsTittle, mNewsSource, mNewsDiscription;
        public PibViewHolder(@NonNull View itemView) {
            super(itemView);
//            mNewsImage = (ImageView) itemView.findViewById(R.id.Pib_imageview);
            mNewsTittle = (TextView) itemView.findViewById(R.id.news_tittle);
            mNewsSource = (TextView) itemView.findViewById(R.id.news_source);
            mNewsDiscription = (TextView) itemView.findViewById(R.id.text_description);

        }
    }
}
