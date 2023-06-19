package com.lcwd.hotel.dto;



import com.lcwd.hotel.entities.Hotel;

import lombok.Data;

@Data
public class HotelDTO {

	private String name;


	public static Hotel getHotel(HotelDTO hotelDTO) {
		return Hotel.builder().name(hotelDTO.getName()).build();
	}
}
