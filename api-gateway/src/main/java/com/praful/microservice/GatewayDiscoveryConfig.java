/**
 * 
 */
package com.praful.microservice;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author jack
 *
 */

@Component
@EnableDiscoveryClient
public class GatewayDiscoveryConfig {

	@Bean
	public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		return builder.routes().route(r -> r.path("/currency-exchange/**").uri("http://localhost:8000/"))
				.route(r -> r.path("/currency-conversion/**").uri("http://localhost:8100/")).build();
	}

}
