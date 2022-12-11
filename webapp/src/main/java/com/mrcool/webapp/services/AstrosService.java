package com.mrcool.webapp.services;

import com.mrcool.webapp.json.Astros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstrosService {

	private final RestTemplate restTemplate;

	private final WebClient webClient;

	@Autowired
	public AstrosService(RestTemplateBuilder builder, WebClient.Builder wcBuilder) {
		this.restTemplate = builder.build();
		this.webClient = wcBuilder.baseUrl("http://api.open-notify.org").build();
	}

	public Astros getAstronauts() {
		String url = "http://api.open-notify.org/astros.json";
		return this.restTemplate.getForObject(url, Astros.class);
	}

	public Astros getAstronautsWc() {
		return this.webClient.get().uri("/astros.json").accept(MediaType.APPLICATION_JSON).retrieve()
				.bodyToMono(Astros.class).block(Duration.ofSeconds(2));
	}

}
