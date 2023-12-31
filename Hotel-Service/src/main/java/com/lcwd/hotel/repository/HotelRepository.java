package com.lcwd.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

	public Hotel findById(int hotelId); 
	
	public Boolean existsByNameIgnoreCase(String name); 
}
