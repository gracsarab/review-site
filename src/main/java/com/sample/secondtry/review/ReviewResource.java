package com.sample.secondtry.review;
//import com.sample.secondtry.review.category.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000","http://localhost:4200" })
@RestController
public class ReviewResource {

    @Autowired
    private ReviewsHardcodedService reviewManagementService;

    @GetMapping("/writers/{username}/reviews")
    public List<Review> getAllReviews(@PathVariable String username) {
        return reviewManagementService.findAll();
    }

    @GetMapping("/writers/{username}/categories/{category}")
    public List<Review> getReviewsbyCat(@PathVariable String username, @PathVariable String category) {
        return reviewManagementService.findByCategory(category);
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

    @PutMapping("writers/{username}/reviews/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String username, @PathVariable long id, @RequestBody Review review){
        Review reviewUpdated = reviewManagementService.save(review);
        return new ResponseEntity<Review>(reviewUpdated, HttpStatus.OK);
    }

    @PostMapping("/writers/{username}/reviews")
    public ResponseEntity<Void> createReview(@PathVariable String username, @RequestBody Review review) {
        Review createdReview = reviewManagementService.save(review);
        //Location
        //Get current resource url
        //{id}
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdReview.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}

