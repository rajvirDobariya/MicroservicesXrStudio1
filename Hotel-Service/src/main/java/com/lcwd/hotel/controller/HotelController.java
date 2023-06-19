package com.lcwd.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.hotel.dto.HotelDTO;
import com.lcwd.hotel.serviceimpl.HotelServiceImpl;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelServiceImpl hotelServiceImpl;

    @PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/")
	public ResponseEntity<Object> create(HotelDTO hotelDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelServiceImpl.createHotel(hotelDTO));
	}

    @PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{hotelId}")
	public ResponseEntity<Object> getHotelById(@PathVariable String hotelId) {
		return ResponseEntity.ok(hotelServiceImpl.findById(hotelId));
	}

    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/all")
	public ResponseEntity<Object> getHotels() {
		return ResponseEntity.ok(hotelServiceImpl.getAll());
	}
}
