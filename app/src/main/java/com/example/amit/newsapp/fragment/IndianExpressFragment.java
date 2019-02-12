package com.example.amit.newsapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.amit.newsapp.newsadapter.NewsAdapter;
import com.example.amit.newsapp.newsclient.NewsClient;
import com.example.amit.newsapp.pojoclassofnewsapi.Articles;
import com.example.amit.newsapp.pojoclassofnewsapi.NewsRoot;
import com.example.amit.newsapp.webhose.Posts;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.amit.newsapp.R;
public class IndianExpressFragment extends Fragment {
    public NewsAdapter mNewsAdapter;
    public List<Articles> mNewsArticles;
    public List<Posts> mPosts;
    public final String Tag = "IndianExpressFragment";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.w(Tag,"onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.w(Tag,"onCreate");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.w(Tag,"onCreateView");
        View lView = inflater.inflate(R.layout.indian_express_recyclerview, container, false);
        final RecyclerView lRecyclerview = lView.findViewById(R.id.indianexpress_recylerview);


        Call<NewsRoot> lEverythingIndianExpressApi = NewsClient.getNewsApi().getEverythingNews("indianexpress.com", "en");
        lEverythingIndianExpressApi.enqueue(new Callback<NewsRoot>() {
            @Override
            public void onResponse(Call<NewsRoot> call, Response<NewsRoot> response) {
                if (response.isSuccessful()) {
                    Log.w(Tag,"response successfull");
                    if (response.body() != null) {
                        mNewsArticles = response.body().getArticles();
                    }
                    mNewsAdapter = new NewsAdapter(mNewsArticles, getContext());
                    LinearLayoutManager lLinearLayoutManager = new LinearLayoutManager(getContext());
                    lLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    lRecyclerview.setLayoutManager(lLinearLayoutManager);
                    lRecyclerview.setAdapter(mNewsAdapter);
                    mNewsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsRoot> call, Throwable t) {
                Log.w("MainActivity", "Failed: " + t.getMessage());
            }
        });
        return lView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.w(Tag,"onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.w(Tag,"onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.w(Tag,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.w(Tag,"onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.w(Tag,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.w(Tag,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.w(Tag,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.w(Tag,"onDetach");
    }


    public class WebhoseAdapter extends RecyclerView.Adapter<WebhoseAdapter.WebhoseViewHolder>{

        @NonNull
        @Override
        public WebhoseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater layoutInflater;
            View lView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.webhouselayout,
                    viewGroup, false);
            return new WebhoseViewHolder(lView);
        }

        @Override
        public void onBindViewHolder(@NonNull WebhoseViewHolder webhoseViewHolder, int aPosition) {
            Glide.with(getContext())
                    .load(mPosts.get(aPosition).getThread().getMain_image())
                    .centerCrop()
                    .into(webhoseViewHolder.mWebhoseImageView);
            webhoseViewHolder.mWebhoseTittle.setText(mPosts.get(aPosition).getThread().getTitle());
            webhoseViewHolder.mWebhoseSource.setText(mPosts.get(aPosition).getThread().getSite());
        }

        @Override
        public int getItemCount() {
            return mPosts.size();
        }

        public class WebhoseViewHolder extends RecyclerView.ViewHolder {
            public ImageView mWebhoseImageView;
            public TextView mWebhoseTittle, mWebhoseSource;
            public WebhoseViewHolder(@NonNull View itemView) {
                super(itemView);

                mWebhoseImageView = (ImageView) itemView.findViewById(R.id.webhose_image);
                mWebhoseTittle = (TextView) itemView.findViewById(R.id.webhose_tittle);
                mWebhoseSource = (TextView) itemView.findViewById(R.id.webhose_source);
            }
        }
    }


}
