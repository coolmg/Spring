package com.mrcool.webapp.services;

import com.mrcool.webapp.json.Response;
import com.mrcool.webapp.json.Site;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class GeocoderService {

	private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

	private final WebClient webClient;

	public GeocoderService(WebClient.Builder wcBuilder) {
		this.webClient = wcBuilder.baseUrl("https://maps.googleapis.com").build();
	}

	public Site getLatLng(String... address) {
		String encoded = Stream.of(address).map(a -> URLEncoder.encode(a, StandardCharsets.UTF_8))
				.collect(Collectors.joining(","));
		// https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=YOUR_API_KEY
		String path = "maps/api/geocode/json";
		Response response = this.webClient.get()
				.uri(uriBuilder -> uriBuilder.path(path).queryParam("address", encoded).queryParam("key", KEY).build())
				.retrieve().bodyToMono(Response.class).block(Duration.ofSeconds(2));

		return new Site(response.getFormattedAddress(), response.getLocation().getLat(),
				response.getLocation().getLng());
	}

}
