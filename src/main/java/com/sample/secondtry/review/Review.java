package com.sample.secondtry.review;
import com.sample.secondtry.review.category.*;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class Review {
	private long id;
    private String username;
    private String title;
    private String content;
    private Category category;

    public Review(long id, String username, String title, String content, Category category) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.category = category;
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
  
    public String getContent(){
        return this.content;
    }

    public String getCategory(){
        return this.category.getName();
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setId(long id){
        this.id = id;
    }
}