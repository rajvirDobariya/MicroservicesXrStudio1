package com.lcwd.user.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcwd.user.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/rating/user/{userId}")
	List<Rating> getRatingsByUserId(@PathVariable("userId") String userId);
}
