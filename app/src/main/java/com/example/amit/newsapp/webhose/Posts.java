package com.example.amit.newsapp.webhose;

import java.util.List;

public class Posts {
    private Thread thread;

    private String uuid;

    private String url;

    private int ord_in_thread;

    private String author;

    private String published;

    private String title;

    private String text;

    private String highlightText;

    private String highlightTitle;

    private String language;

    private List<String> external_links;

    private Entities entities;

    private String rating;

    private String crawled;

    public void setThread(Thread thread){
        this.thread = thread;
    }
    public Thread getThread(){
        return this.thread;
    }
    public void setUuid(String uuid){
        this.uuid = uuid;
    }
    public String getUuid(){
        return this.uuid;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setOrd_in_thread(int ord_in_thread){
        this.ord_in_thread = ord_in_thread;
    }
    public int getOrd_in_thread(){
        return this.ord_in_thread;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public String getAuthor(){
        return this.author;
    }
    public void setPublished(String published){
        this.published = published;
    }
    public String getPublished(){
        return this.published;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
    public void setHighlightText(String highlightText){
        this.highlightText = highlightText;
    }
    public String getHighlightText(){
        return this.highlightText;
    }
    public void setHighlightTitle(String highlightTitle){
        this.highlightTitle = highlightTitle;
    }
    public String getHighlightTitle(){
        return this.highlightTitle;
    }
    public void setLanguage(String language){
        this.language = language;
    }
    public String getLanguage(){
        return this.language;
    }
    public void setExternal_links(List<String> external_links){
        this.external_links = external_links;
    }
    public List<String> getExternal_links(){
        return this.external_links;
    }
    public void setEntities(Entities entities){
        this.entities = entities;
    }
    public Entities getEntities(){
        return this.entities;
    }
    public void setRating(String rating){
        this.rating = rating;
    }
    public String getRating(){
        return this.rating;
    }
    public void setCrawled(String crawled){
        this.crawled = crawled;
    }
    public String getCrawled(){
        return this.crawled;
    }
}
