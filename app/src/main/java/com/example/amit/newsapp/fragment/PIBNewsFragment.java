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

import com.example.amit.newsapp.newsadapter.PibNewsAdapter;
import com.example.amit.newsapp.newsclient.NewsClient;
import com.example.amit.newsapp.pojoclassofnewsapi.Articles;
import com.example.amit.newsapp.pojoclassofnewsapi.NewsRoot;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduRoot;
import com.example.amit.newsapp.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PIBNewsFragment extends Fragment {
    public final String Tag = "PIBNews";
    public List<Articles> mPIBNewsArticles;
    public PibNewsAdapter mPibNewsAdapter;
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
        View lView = inflater.inflate(R.layout.pib_news_recyclerview, container, false);
        final RecyclerView lRecyclerview = lView.findViewById(R.id.pibnews_recylerview);
        Log.w(Tag,"onCreateView");
        Call<NewsRoot> lEverythingNewsApi = NewsClient.getTheHinduNewsApi().getEverythingNews("pib.nic.in", "en");
        lEverythingNewsApi.enqueue(new Callback<NewsRoot>() {
            @Override
            public void onResponse(Call<NewsRoot> call, Response<NewsRoot> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        mPIBNewsArticles = response.body().getArticles();
                    }
                    mPibNewsAdapter = new PibNewsAdapter(mPIBNewsArticles, getContext());
                    final LinearLayoutManager lLinearLayoutManager = new LinearLayoutManager(getContext());
                    lLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    lRecyclerview.setLayoutManager(lLinearLayoutManager);
                    lRecyclerview.setAdapter(mPibNewsAdapter);
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
        Log.w(Tag, "onStart");
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
        Log.w(Tag,"onDestroy");
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

}
