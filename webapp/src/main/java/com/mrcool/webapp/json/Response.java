package com.mrcool.webapp.json;

import lombok.Data;

import java.util.List;

@Data
public class Response {

	private List<Result> results;

	private String status;

	public Location getLocation() {
		return results.get(0).getGeometry().getLocation();
	}

	public String getFormattedAddress() {
		return results.get(0).getFormattedAddress();
	}

}
