/**
 * 
 */
package com.praful.microservice.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author jack
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Limits {
	private int minimum;
	private int maximum;
}
