package com.sample.secondtry.review;
import com.sample.secondtry.review.category.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ReviewsHardcodedService {
    private static List<Review> reviews = new ArrayList<Review>();
    private static long idCounter = 0;
    private static List<Category> categories = new ArrayList<Category>();
    
    static{
        categories.add(new Category(1, "game"));
        categories.add(new Category(2, "animation"));
    }
    
    static{
        reviews.add(new Review(++idCounter, "Graciela", "The Last Express", "", categories.get(0)));
        reviews.add(new Review(++idCounter, "Graciela", "Shadow at the Water's Edge", "", categories.get(0)));
        reviews.add(new Review(++idCounter, "Graciela", "Syberia", "", categories.get(0)));
        reviews.add(new Review(++idCounter, "Graciela", "Fantastic Planet", "", categories.get(1)));
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

    public List<Review> findByCategory(String category) {
        List<Review> reviewsByCat = new ArrayList<Review>();
        for(Review review: reviews) {
            if (review.getCategory() == category) {
                reviewsByCat.add(review);
            }
            return reviewsByCat;
        }
        return reviewsByCat;
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