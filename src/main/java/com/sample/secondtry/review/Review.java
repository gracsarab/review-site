package com.sample.secondtry.review;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

//model object
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Review {
	private long id;
    private String username;
    private String title;
    private String text;

    public Review(long id, String username, String title, String text) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.text = text;
    }

    public long getId(){
        return this.id;
    }

    public String getUsername(){
        return this.username;
    }
    
    public String getTitle(){
        return this.title;
    }
  
    public String getText(){
        return this.text;
    }

    public void setId(long id){
        this.id = id;
    }
}