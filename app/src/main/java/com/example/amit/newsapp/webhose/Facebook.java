package com.example.amit.newsapp.webhose;

public class Facebook {
    private int likes;

    private int comments;

    private int shares;

    public void setLikes(int likes){
        this.likes = likes;
    }
    public int getLikes(){
        return this.likes;
    }
    public void setComments(int comments){
        this.comments = comments;
    }
    public int getComments(){
        return this.comments;
    }
    public void setShares(int shares){
        this.shares = shares;
    }
    public int getShares(){
        return this.shares;
    }
}
