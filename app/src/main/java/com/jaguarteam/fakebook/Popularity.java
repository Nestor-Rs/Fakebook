package com.jaguarteam.fakebook;

public class Popularity {
    private int likes;
    private int coments;
    private int shares;

    Popularity(){
        this.likes=0;
        this.coments=0;
        this.shares=0;
    }

    public int getLikes() {
        return likes;
    }
    public void oneLike(){
        likes++;
    }
    public int getComents() {
        return coments;
    }
    public void oneComent(){
        coments++;
    }
    public int getShares() {
        return shares;
    }
    public void oneShare(){
        shares++;
    }
}
