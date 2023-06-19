package com.lcwd.user.dto;

import com.lcwd.user.entities.User;

import lombok.Data;

@Data
public class UserDTO {

	private String name;
	private String password;

	public static User getUser(UserDTO userDTO) {
		return User.builder().name(userDTO.getName()).password(userDTO.getPassword()).build();
	}
}
