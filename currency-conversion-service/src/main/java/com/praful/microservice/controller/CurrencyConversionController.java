/**
 * 
 */
package com.praful.microservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.praful.microservice.data.model.CurrencyConversion;
import com.praful.microservice.service.CurrencyExchangeProxy;

/**
 * @author jack
 *
 */
@RestController
public class CurrencyConversionController {

	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	
	@GetMapping("/curency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();

		uriVariables.put("from", from);
		uriVariables.put("to", to);

		CurrencyConversion response = new RestTemplate()
				.getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}/",
						CurrencyConversion.class, uriVariables)
				.getBody();

		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()));
	}
	
	@GetMapping("/curency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<String, String>();

		uriVariables.put("from", from);
		uriVariables.put("to", to);

		
		CurrencyConversion response = this.currencyExchangeProxy.retrieveExchange(from, to);
		


		return new CurrencyConversion(response.getId(), from, to, response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()));
	}
	
	

}
