package com.sample.secondtry.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000","http://localhost:4200" })
@RestController
public class ReviewResource {

    @Autowired
    private ReviewsHardcodedService reviewManagementService;

    @GetMapping("/writers/{username}/reviews")
    public List<Review> getAllReviews(@PathVariable("username") String username) {
        return reviewManagementService.findAll();
    }

    @DeleteMapping("/writers/{username}/reviews/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable String username, @PathVariable long id) {
        Review review = reviewManagementService.deleteById(id);

        if (review != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("writers/{username}/reviews/{id}")
    public Review getReview(@PathVariable String username, @PathVariable long id){
        return reviewManagementService.findById(id);
    }

}

