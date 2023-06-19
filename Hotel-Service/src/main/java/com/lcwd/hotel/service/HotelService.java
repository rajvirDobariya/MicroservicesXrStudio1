package com.lcwd.hotel.service;

import com.lcwd.hotel.dto.HotelDTO;
import com.lcwd.hotel.entities.Hotel;

public interface HotelService {

	public Hotel createHotel(HotelDTO hotelDTO);
	
}
