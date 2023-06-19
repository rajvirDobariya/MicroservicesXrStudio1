package com.lcwd.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lcwd.user.dto.UserDTO;
import com.lcwd.user.entities.User;
import com.lcwd.user.serviceimpl.UserServiceImpl;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserServiceImpl userServiceImpl;

	@PostMapping("/")
	public ResponseEntity<Object> createUser(UserDTO userDTO) {

		return new ResponseEntity<>(userServiceImpl.createUser(userDTO), HttpStatus.CREATED);
	}

	int retryCount = 1;

	@GetMapping("/{userId}")
//  @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//  @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
//	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<Object> getByUserId(@PathVariable String userId) {
		logger.info("Retry count: {}", retryCount);
		retryCount++;
		return new ResponseEntity<>(userServiceImpl.findByUserId(userId), HttpStatus.OK);
	}

	// ratingHotelFallBack
	public ResponseEntity<Object> ratingHotelFallback(String userId, Exception ex) {
//		logger.info("Fallback is executed because serviceis down : ",ex.getMessage());
		ex.printStackTrace();
		User user = User.builder().name("Dummy").userId("1234567890").build();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<Object> getUsers() {
		return new ResponseEntity<Object>(userServiceImpl.getAll(), HttpStatus.OK);
	}

//	@DeleteMapping("/all")
//	public void deleteAll() {
//			userServiceImpl.deleteAll();
//	}
}
