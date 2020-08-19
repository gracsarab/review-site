package com.sample.secondtry.review.category;
// import java.util.List;
// import com.sample.secondtry.review.Review;

public class Category {
    private long id;
    private String name;

    public Category(long id, String name){
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}