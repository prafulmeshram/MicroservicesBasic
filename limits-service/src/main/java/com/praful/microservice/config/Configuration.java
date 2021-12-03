/**
 * 
 */
package com.praful.microservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author jack
 *
 */


@Component
@ConfigurationProperties("limits-service")
@Data
public class Configuration {

	private int minimum;
	private int maximum;
	
}
