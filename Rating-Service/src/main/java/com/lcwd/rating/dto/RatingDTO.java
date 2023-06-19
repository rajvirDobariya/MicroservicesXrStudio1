package com.lcwd.rating.dto;

import com.lcwd.rating.entities.Rating;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RatingDTO {
	private String userId;
	private String hotelId;
	private String feedback;
	private int rating;

	public Rating getRating(RatingDTO ratingDTO) {
		return Rating.builder().feedback(ratingDTO.getFeedback()).userId(ratingDTO.getUserId())
				.hotelId(ratingDTO.hotelId).rating(ratingDTO.getRating()).build();
	}
}
