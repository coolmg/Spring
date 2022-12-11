package com.mrcool.webapp.json;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Site {

	private String name;

	private double latitude;

	private double longitude;

}
