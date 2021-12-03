/**
 * 
 */
package com.praful.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praful.microservice.data.model.CurrencyExchange;

/**
 * @author jack
 *
 */
@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

	CurrencyExchange findByFromAndTo(String from, String to);

}
