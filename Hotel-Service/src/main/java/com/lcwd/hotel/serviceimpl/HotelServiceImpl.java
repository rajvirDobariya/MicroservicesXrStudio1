package com.lcwd.hotel.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.hotel.dto.HotelDTO;
import com.lcwd.hotel.entities.Hotel;
import com.lcwd.hotel.exception.HotelException;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import com.lcwd.hotel.utils.Messages;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(HotelDTO hotelDTO) {

		existByName(hotelDTO.getName());
		
		Hotel hotel = HotelDTO.getHotel(hotelDTO);
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}
	public List<Hotel> getAll(){
		return hotelRepository.findAll();
	}


	public boolean existById(String hotelId) {
		if (hotelRepository.existsById(hotelId)) {
			throw new HotelException(Messages.HOTEL_ALREADY_EXISTS);
		}
		return true;
	}

	public boolean existByName(String name) {
		if (hotelRepository.existsByNameIgnoreCase(name)) {
			throw new HotelException(Messages.HOTEL_ALREADY_EXISTS);
		}
		return true;
	}

	public Hotel findById(String hotelId) {
		Optional<Hotel> hotel = hotelRepository.findById(hotelId.trim());

		if (hotel.isEmpty()) {
			throw new HotelException(Messages.HOTEL_NOT_FOUND);
		}
		return hotel.get();
	}
}
