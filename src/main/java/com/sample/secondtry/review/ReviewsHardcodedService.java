package com.sample.secondtry.review;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReviewsHardcodedService {
    private static List<Review> reviews = new ArrayList<Review>();
    private static long idCounter = 0;

    static{
        reviews.add(new Review(++idCounter, "Graciela", "The Last Express", ""));
        reviews.add(new Review(++idCounter, "Graciela", "Nancy Drew: Shadow at the Water's Edge", ""));
        reviews.add(new Review(++idCounter, "Graciela", "Syberia", ""));
        reviews.add(new Review(++idCounter, "Graciela", "Fantastic Planet", ""));
    }
    
    public List<Review> findAll() {
        return reviews;
    }

    public Review findById(long id) {
        for(Review review: reviews) {
            if (review.getId() == id) {
                return review;
            }
        }
        return null;
    }

    public Review deleteById(long id){
        Review review = findById(id);

        if (review == null) {
            return null;
        }

        if (reviews.remove(review)){
            return review;
        }
        return null;
    }

    public Review save(Review review){
        if (review.getId() == -1 || review.getId() == 0){
            review.setId(++idCounter);
            reviews.add(review);
        }
        else {
            deleteById(review.getId());
            reviews.add(review);
        }
        return review;
    }
}