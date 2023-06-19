package com.lcwd.rating.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.dto.RatingDTO;
import com.lcwd.rating.serviceiml.RatingServiceImpl;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@Autowired
	private RatingServiceImpl ratingServiceImpl;

    @PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/")
	public ResponseEntity<Object> create(RatingDTO ratingDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceImpl.create(ratingDTO));
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getRatings() {
		return ResponseEntity.ok(ratingServiceImpl.getAll());
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Object> getRatingById(@PathVariable String ratingId) {
		return ResponseEntity.ok(ratingServiceImpl.findByRatingId(ratingId));
	}

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/user/{userId}")
	public ResponseEntity<Object> getRatingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(ratingServiceImpl.getRatingByUserId(userId));
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<Object> getRatingsByHotelId(@PathVariable String hotelId) {
		return ResponseEntity.ok(ratingServiceImpl.getRatingByHotelId(hotelId));
	}
}
