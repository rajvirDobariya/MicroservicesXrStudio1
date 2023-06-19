package com.lcwd.rating.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.dto.RatingDTO;
import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl {

	@Autowired
	private RatingRepository ratingRepository;


	public Rating create(RatingDTO ratingDTO) {
		return ratingRepository.save(ratingDTO.getRating(ratingDTO));
	}

	public List<Rating> getAll() {
		return ratingRepository.findAll();
	}
	
	public Rating findByRatingId(String ratingId) {
		return ratingRepository.findByRatingId(ratingId);
	}
	
	public List<Rating> getRatingByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

}
