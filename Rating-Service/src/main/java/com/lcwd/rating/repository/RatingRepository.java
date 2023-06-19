package com.lcwd.rating.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lcwd.rating.entities.Rating;

public interface RatingRepository extends MongoRepository<Rating, Integer> {

	Rating findByRatingId(String ratingId);

	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String hotelId);
}
