/**
 * 
 */
package com.praful.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.praful.microservice.data.model.CurrencyExchange;
import com.praful.microservice.repository.CurrencyExchangeRepository;

/**
 * @author jack
 *
 */
@RestController
public class CurrencyExchangeController {

	/*
	 * @Autowired private Environment environment;
	 */

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchange(@PathVariable String from, @PathVariable String to) {

		CurrencyExchange currencyExchange = this.currencyExchangeRepository.findByFromAndTo(from, to);

		if(currencyExchange !=null) 
			return currencyExchange;
		else
			throw new RuntimeException("Unale To Find The Data");
		
		
//		return new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(100),
//				environment.getProperty("local.server.port"));
	}

}
