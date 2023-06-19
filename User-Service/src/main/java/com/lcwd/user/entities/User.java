package com.lcwd.user.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name ="users")
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private String userId;
	
	@Column(name="name", length = 10)
	private String name;
	
	private String password;
	
	@Transient//database ma save na karva mate
	private List<Rating> ratings = new ArrayList<>();
}
