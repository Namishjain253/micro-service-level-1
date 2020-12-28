package com.n2n.moviecatalogservice.recources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.n2n.moviecatalogservice.models.CatelogItem;
import com.n2n.moviecatalogservice.models.Movie;
import com.n2n.moviecatalogservice.models.Rating;
import com.n2n.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatelogResource {

	@Autowired
	private RestTemplate restTemplate;
	
	/*@Autowired
	private WebClient.Builder webClientBuilder; */

	@RequestMapping("/{userId}")
	public List<CatelogItem> getCatalog(@PathVariable("userId") String userId) {
		
		UserRating userRating = restTemplate.getForObject("http://movie-rating-service/ratingsdata/users/" + userId, UserRating.class);
		
		return userRating.getUserRatings().stream().map(rating -> {
				
			// for each movie ID, call movie info service and get details
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			return new CatelogItem(movie.getName(), "Test", rating.getRating());
		
		}).collect(Collectors.toList());
		
		// put all together
	}
}


/*Movie movie = webClientBuilder.build()
		.get()
		.uri("http://localhost:8082/movies/" + rating.getMovieId())
		.retrieve()
		.bodyToMono(Movie.class)
		.block();*/