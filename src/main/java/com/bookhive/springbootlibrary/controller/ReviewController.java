package com.bookhive.springbootlibrary.controller;

import com.bookhive.springbootlibrary.requestmodels.ReviewRequest;
import com.bookhive.springbootlibrary.service.ReviewService;
import com.bookhive.springbootlibrary.utils.ExtractJWT;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/secure")
    public void postReview(@RequestHeader(value = "Authorization") String token,
                           @RequestBody ReviewRequest reviewRequest) throws Exception{
        String userEmail = ExtractJWT.payloadJWTExtraction(token, "\"sub\"");
        if (userEmail == null){
            throw new Exception("User email is not available");
        }
        reviewService.postReview(userEmail, reviewRequest);

    }
}
