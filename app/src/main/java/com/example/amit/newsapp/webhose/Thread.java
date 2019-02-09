package com.example.amit.newsapp.webhose;

import java.util.List;

public class Thread {
    private String uuid;

    private String url;

    private String site_full;

    private String site;

    private String site_section;

    private List<String> site_categories;

    private String section_title;

    private String title;

    private String title_full;

    private String published;

    private int replies_count;

    private int participants_count;

    private String site_type;

    private String country;

    private float spam_score;

    private String main_image;

    private int performance_score;

    private int domain_rank;

    private Social social;

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
    public void setSite_full(String site_full){
        this.site_full = site_full;
    }
    public String getSite_full(){
        return this.site_full;
    }
    public void setSite(String site){
        this.site = site;
    }
    public String getSite(){
        return this.site;
    }
    public void setSite_section(String site_section){
        this.site_section = site_section;
    }
    public String getSite_section(){
        return this.site_section;
    }
    public void setSite_categories(List<String> site_categories){
        this.site_categories = site_categories;
    }
    public List<String> getSite_categories(){
        return this.site_categories;
    }
    public void setSection_title(String section_title){
        this.section_title = section_title;
    }
    public String getSection_title(){
        return this.section_title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTitle_full(String title_full){
        this.title_full = title_full;
    }
    public String getTitle_full(){
        return this.title_full;
    }
    public void setPublished(String published){
        this.published = published;
    }
    public String getPublished(){
        return this.published;
    }
    public void setReplies_count(int replies_count){
        this.replies_count = replies_count;
    }
    public int getReplies_count(){
        return this.replies_count;
    }
    public void setParticipants_count(int participants_count){
        this.participants_count = participants_count;
    }
    public int getParticipants_count(){
        return this.participants_count;
    }
    public void setSite_type(String site_type){
        this.site_type = site_type;
    }
    public String getSite_type(){
        return this.site_type;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setSpam_score(int spam_score){
        this.spam_score = spam_score;
    }
    public float getSpam_score(){
        return this.spam_score;
    }
    public void setMain_image(String main_image){
        this.main_image = main_image;
    }
    public String getMain_image(){
        return this.main_image;
    }
    public void setPerformance_score(int performance_score){
        this.performance_score = performance_score;
    }
    public int getPerformance_score(){
        return this.performance_score;
    }
    public void setDomain_rank(int domain_rank){
        this.domain_rank = domain_rank;
    }
    public int getDomain_rank(){
        return this.domain_rank;
    }
    public void setSocial(Social social){
        this.social = social;
    }
    public Social getSocial(){
        return this.social;
    }
}
