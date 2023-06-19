package com.lcwd.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {

	@GetMapping("/all")
	public ResponseEntity<Object> getStafs() {
		
		List<String> list = Arrays.asList("Ram","Sita","Laxman");
		return ResponseEntity.ok(list);
	}

}
