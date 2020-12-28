package com.n2n.movieratingservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.n2n.movieratingservice.models.Rating;
import com.n2n.movieratingservice.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {

	@RequestMapping("/{movieId}")
	public Rating getRatingInfo(@PathVariable("movieId") String movieId) {
		return new Rating(movieId, 4);
	}

	@RequestMapping("users/{userId}")
	public UserRating getUserRatingInfo(@PathVariable("userId") String userId) {
		List<Rating> ratings = Arrays.asList(new Rating("1234", 4), new Rating("5678", 3));
		UserRating userRating = new UserRating();
		userRating.setUserRatings(ratings);
		return userRating;
	}
}
