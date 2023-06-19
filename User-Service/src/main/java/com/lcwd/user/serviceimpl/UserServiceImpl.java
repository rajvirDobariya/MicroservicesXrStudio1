package com.lcwd.user.serviceimpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.user.dto.UserDTO;
import com.lcwd.user.entities.Hotel;
import com.lcwd.user.entities.Rating;
import com.lcwd.user.entities.User;
import com.lcwd.user.exception.UserException;
import com.lcwd.user.external.HotelService;
import com.lcwd.user.external.RatingService;
import com.lcwd.user.repository.UserRepository;
import com.lcwd.user.utils.Messages;

@Service
public class UserServiceImpl {

	@Autowired
	private UserRepository userRepository;

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@Autowired
//	private LoadBalancerClient loadBalancerClient;

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;

	public User createUser(UserDTO userDTO) {

		existByName(userDTO.getName());

		User user = UserDTO.getUser(userDTO);
		String userID = UUID.randomUUID().toString();
		user.setUserId(userID);
		return userRepository.save(user);
	}

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public boolean existById(String userId) {
		if (userRepository.existsById(userId)) {
			throw new UserException(Messages.USER_ALREADY_EXISTS);
		}
		return true;
	}

	/**
	 * Using Feign client
	 **/
	public User findByUserId(String userId) {
		User user = userRepository.findByUserId(userId);
		if (user == null) {
			throw new UserException(Messages.USER_NOT_FOUND);
		}

		List<Rating> ratingList = ratingService.getRatingsByUserId(userId);

		// Iterate through the ratingList and set the hotel for each Rating object
		ratingList = ratingList.stream().map(rating -> {
			Hotel hotel = hotelService.getHotelById(rating.getHotelId());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList);
		ratingList.forEach(r -> System.out.println(r.getUserId()));
		return user;
	}

	/**
	 * Using RestTemplate
	 **/
//	 public User findByUserId(String userId) {
//	 User user = userRepository.findByUserId(userId);
//	 if (user == null) {
//	 throw new UserException(Messages.USER_NOT_FOUND);
//	 }
//	
//	 // Get the service instance using the service name
//	 ServiceInstance ratingServiceInstance =
//	 loadBalancerClient.choose("RATING_SERVICE");
//	 ServiceInstance hotelServiceInstance =
//	 loadBalancerClient.choose("HOTEL_SERVICE");
//	
//	 // Construct the URL using the host and port of the service instances
//	 String ratingUrl = "http://" + ratingServiceInstance.getHost() + ":" +
//	 ratingServiceInstance.getPort()
//	 + "/rating/user/" + user.getUserId();
//	 String hotelUrl = "http://" + hotelServiceInstance.getHost() + ":" +
//	 hotelServiceInstance.getPort() + "/hotel/";
//	
//	 // Make the GET request and retrieve the response
//	 ResponseEntity<List<Rating>> responseEntity =
//	 restTemplate.exchange(ratingUrl, HttpMethod.GET, null,
//	 new ParameterizedTypeReference<List<Rating>>() {
//	 });
//	 List<Rating> ratingList = responseEntity.getBody();
//	
//	 // Iterate through the ratingList and set the hotel for each Rating object
//	 ratingList = ratingList.stream().map(rating -> {
//	 String hotelSpecificUrl = hotelUrl + rating.getHotelId();
//	 Hotel hotel = restTemplate.getForObject(hotelSpecificUrl, Hotel.class);
//	 rating.setHotel(hotel);
//	 return rating;
//	 }).collect(Collectors.toList());
//	
//	 user.setRatings(ratingList);
//	 ratingList.forEach(r -> System.out.println(r.getUserId()));
//	 return user;
//	 }

	public boolean existByName(String name) {
		if (userRepository.existsByNameIgnoreCase(name)) {
			throw new UserException(Messages.USER_ALREADY_EXISTS);
		}
		return true;
	}

	public void deleteAll() {
		userRepository.deleteAll();
	}
}
