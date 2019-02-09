package com.example.amit.newsapp.webhose;

import java.util.List;

public class WebhoseRoot {
    private List<Posts> posts;

    private int totalResults;

    private int moreResultsAvailable;

    private String next;

    private int requestsLeft;

    private String warnings;

    public void setPosts(List<Posts> posts){
        this.posts = posts;
    }
    public List<Posts> getPosts(){
        return this.posts;
    }
    public void setTotalResults(int totalResults){
        this.totalResults = totalResults;
    }
    public int getTotalResults(){
        return this.totalResults;
    }
    public void setMoreResultsAvailable(int moreResultsAvailable){
        this.moreResultsAvailable = moreResultsAvailable;
    }
    public int getMoreResultsAvailable(){
        return this.moreResultsAvailable;
    }
    public void setNext(String next){
        this.next = next;
    }
    public String getNext(){
        return this.next;
    }
    public void setRequestsLeft(int requestsLeft){
        this.requestsLeft = requestsLeft;
    }
    public int getRequestsLeft(){
        return this.requestsLeft;
    }
    public void setWarnings(String warnings){
        this.warnings = warnings;
    }
    public String getWarnings(){
        return this.warnings;
    }

}
