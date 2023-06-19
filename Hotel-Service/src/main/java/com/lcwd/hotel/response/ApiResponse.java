package com.lcwd.hotel.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ApiResponse {

	private List<Object> dataArray;

	private Object data;

	private long timestamp;

	private ApiResponse() {
		timestamp = new Date().getTime();
	}

	public ApiResponse(Object object) {
		this();
		this.data = object;
	}

	public ApiResponse(List<Object> objects) {
		this();
		this.dataArray = objects;
	}

	public ApiResponse(Object object, List<Object> objects) {
		this.data = object;
		this.dataArray = objects;
	}
}
