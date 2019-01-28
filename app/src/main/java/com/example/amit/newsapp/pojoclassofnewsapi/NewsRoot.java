package com.example.amit.newsapp.pojoclassofnewsapi;

import java.util.List;

public class NewsRoot {
    private String status;

    private int totalResults;

    private List<Articles> articles;

    public void setStatus(String status){
        this.status = status;
    }
    public String getStatus(){
        return this.status;
    }
    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }
    public int getTotalResults(){
        return this.totalResults;
    }
    public void setArticles(List<Articles> articles){
        this.articles = articles;
    }
    public List<Articles> getArticles(){
        return this.articles;
    }
}
