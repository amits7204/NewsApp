package com.example.amit.newsapp.pojoclassofnewsapi.thehindu;

import java.util.List;

public class TheHinduRoot {
    private String status;

    private int totalResults;

    private List<TheHinduArticles> articles;

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
    public void setArticles(List<TheHinduArticles> articles){
        this.articles = articles;
    }
    public List<TheHinduArticles> getArticles(){
        return this.articles;
    }
}
