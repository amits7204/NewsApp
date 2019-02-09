package com.example.amit.newsapp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amit.newsapp.newsadapter.TheHinduAdapter;
import com.example.amit.newsapp.newsapi.NewsApi;
import com.example.amit.newsapp.newsclient.NewsClient;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduArticles;
import com.example.amit.newsapp.pojoclassofnewsapi.thehindu.TheHinduRoot;
import com.example.amit.newsapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TheHinduFragment extends Fragment {
    public final String Tag= "TheHinduFragment";
    private List<TheHinduArticles> mTheHinduArticles;
    private TheHinduAdapter mTheHinduAdapter;
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        Log.w(Tag,"onCreateView");
        View lView = inflater.inflate(R.layout.thehindurecyclerview, container, false);
        final RecyclerView lRecyclerView = lView.findViewById(R.id.thehindu_recylerview);
        NewsApi lNewsApi = NewsClient.getTheHinduNewsApi();
        Call<TheHinduRoot> lTheHinduRootApi = lNewsApi.getTheHinduNewsRoot("the-hindu");
        lTheHinduRootApi.enqueue(new Callback<TheHinduRoot>() {
            @Override
            public void onResponse(Call<TheHinduRoot> call, Response<TheHinduRoot> response) {
                if (response.isSuccessful()){
                    if (response.body() != null) {
                        mTheHinduArticles = response.body().getArticles();
                    }
                    mTheHinduAdapter = new TheHinduAdapter(mTheHinduArticles, getContext());
                    LinearLayoutManager lLinearLayOutManager = new LinearLayoutManager(getContext());
                    lRecyclerView.setLayoutManager(lLinearLayOutManager);
                    lRecyclerView.setAdapter(mTheHinduAdapter);
                }
            }

            @Override
            public void onFailure(Call<TheHinduRoot> call, Throwable t) {

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
}
