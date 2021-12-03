/**
 * 
 */
package com.praful.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

/**
 * @author jack
 *
 */
@RestController
public class CircuitBreakerController {

	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")
	//@CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse")
	@RateLimiter(name = "default")
	@Bulkhead(name = "default")
	public String sampleApi() {
		new RestTemplate().getForEntity("", String.class);
		
		return "Sample API";
	}
	
	
	
	public String hardCodedResponse(Exception ex) {
		return "fallback Response";
	}
	
	
}
