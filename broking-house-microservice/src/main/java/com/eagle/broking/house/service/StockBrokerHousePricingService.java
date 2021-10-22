/*
 * 
 */
package com.eagle.broking.house.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eagle.broking.house.vo.Scrip;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
/**
 * 
 * @author Durga Prasad
 *
 * The StockBrokerHousePricingService class.
 *
 */
@Service
public class StockBrokerHousePricingService implements IStockBrokerHousePricingService {

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;
	
	/** The hedge hog stock exchange url. */
	@Value("${hedgehog.scripInfoUrl}")
	private String hedgeHogStockExchangeUrl;
	
	/** The hedge hog stock lagging exchange url. */
	@Value("${hedgehog.laggingScripInfoUrl}")
	private String hedgeHogStockLaggingExchangeUrl;
	
	@Value("${hedgehog.hedgeHogStockInvalidExchangeUrl}")
	private String hedgeHogStockInvalidExchangeUrl;
	
	
	/**
	 * Gets the scrip price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip price
	 */
	@Override
	public Scrip getScripPrice(Integer scripId) {
		Scrip scrip =  restTemplate.getForObject(hedgeHogStockExchangeUrl +scripId, Scrip.class);
		return scrip;
	}
	
	/**
	 * Default scrip info. Fallback method of the circuit breaker
	 *
	 * @param exception the exception
	 * @return the scrip
	 */
	public Scrip defaultScripInfo(Exception exception) {
		Scrip scrip =  new Scrip();
		scrip.setErrorCode("Fall back method called.....HedgeHog Exchange Timeout");
		return scrip;
	}

	/**
	 * Gets the scrip price ckt brkr.
	 *
	 * @param scripId the scrip id
	 * @return the scrip price ckt brkr
	 */
	@Override
	@CircuitBreaker(name="scripInfoBreaker", fallbackMethod = "defaultScripInfo")
	public Scrip getScripPriceCktBrkr(Integer scripId) {
		Scrip scrip =  restTemplate.getForObject(hedgeHogStockLaggingExchangeUrl +scripId, Scrip.class);
		return scrip;
	}

	@Override
	@CircuitBreaker(name="scripInfoBreaker", fallbackMethod = "defaultScripInfoUnAvail")
	public Scrip getScripPriceCktBrkrServiceUnavail(Integer scripId) {
		Scrip scrip =  restTemplate.getForObject(hedgeHogStockInvalidExchangeUrl +scripId, Scrip.class);
		return scrip;
	}

	
	/**
	 * Default scrip info un avail.
	 *
	 * @param exception the exception
	 * @return the scrip
	 */
	public Scrip defaultScripInfoUnAvail(Exception exception) {
		Scrip scrip =  new Scrip();
		scrip.setErrorCode("Fall back method called.....HedgeHog Exchange Service Down");
		return scrip;
	}
}
