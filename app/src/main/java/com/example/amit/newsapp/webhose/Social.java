package com.example.amit.newsapp.webhose;

public class Social {
    private Facebook facebook;

    private Gplus gplus;

    private Pinterest pinterest;

    private Linkedin linkedin;

    private Stumbledupon stumbledupon;

    private Vk vk;

    public void setFacebook(Facebook facebook){
        this.facebook = facebook;
    }
    public Facebook getFacebook(){
        return this.facebook;
    }
    public void setGplus(Gplus gplus){
        this.gplus = gplus;
    }
    public Gplus getGplus(){
        return this.gplus;
    }
    public void setPinterest(Pinterest pinterest){
        this.pinterest = pinterest;
    }
    public Pinterest getPinterest(){
        return this.pinterest;
    }
    public void setLinkedin(Linkedin linkedin){
        this.linkedin = linkedin;
    }
    public Linkedin getLinkedin(){
        return this.linkedin;
    }
    public void setStumbledupon(Stumbledupon stumbledupon){
        this.stumbledupon = stumbledupon;
    }
    public Stumbledupon getStumbledupon(){
        return this.stumbledupon;
    }
    public void setVk(Vk vk){
        this.vk = vk;
    }
    public Vk getVk(){
        return this.vk;
    }
}
