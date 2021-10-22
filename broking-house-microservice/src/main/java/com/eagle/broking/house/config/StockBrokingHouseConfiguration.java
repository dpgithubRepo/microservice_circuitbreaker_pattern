/*
 * 
 */
package com.eagle.broking.house.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
@Configuration

/** The Constant log. */
@Slf4j

/**
 * The Class StockBrokingHouseConfiguration.
 * 
 * @author Durga Prasad
 *
 */
public class StockBrokingHouseConfiguration {

	/**
	 * Creates the rest template.
	 *
	 * @return the rest template
	 */
	@Bean
	public RestTemplate createRestTemplate() {
		log.info("in StockBrokingHouseConfiguration ::  in createRestTemplate method");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
}
