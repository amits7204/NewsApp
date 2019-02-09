package com.example.amit.newsapp.webhose;

public class Organizations {
    private String name;

    private String sentiment;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setSentiment(String sentiment){
        this.sentiment = sentiment;
    }
    public String getSentiment(){
        return this.sentiment;
    }
}
