/*
 * 
 */
package com.eagle.broking.house.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.broking.house.service.IStockBrokerHousePricingService;
import com.eagle.broking.house.vo.Scrip;

import lombok.extern.slf4j.Slf4j;

@RestController

/** The Constant log. */
@Slf4j

/**
 * The Class StockBrokingHouseResource.
 * 
 * @author Durga Prasad
 *
 */
public class StockBrokingHouseResource {
	
	/** The SBH pricing service. */
	@Autowired
	private IStockBrokerHousePricingService SBHPricingService;
	
	
	/**
	 * Gets the client scrip info.
	 *
	 * @param scripId the scrip id
	 * @return the client scrip info
	 */
	@GetMapping("/client/scrip/{id}")
	public Scrip getClientScripInfo(@PathVariable("id") Integer scripId) {
		log.info("in StockBrokingHouseResource :: getClientScripInfo request for scripid :: {}", scripId);
		return SBHPricingService.getScripPrice(scripId);
	}
	
	
	/**
	 * Gets the client scrip info with ckt brkr.
	 *
	 * @param scripId the scrip id
	 * @return the client scrip info with ckt brkr
	 */
	@GetMapping("/client/scrip/cktBrkr/timeout/{id}")
	public Scrip getClientScripInfoWithCktBrkr(@PathVariable("id") Integer scripId) {
		log.info("in StockBrokingHouseResource :: getClientScripInfo request for scripid :: {}", scripId);
		return SBHPricingService.getScripPriceCktBrkr(scripId);
	}
	
	@GetMapping("/client/scrip/cktBrkr/unavail/{id}")
	public Scrip getClientScripInfoWithCktBrkrServiceUnavail(@PathVariable("id") Integer scripId) {
		log.info("in StockBrokingHouseResource :: getClientScripInfo request for scripid :: {}", scripId);
		return SBHPricingService.getScripPriceCktBrkrServiceUnavail(scripId);
	}

}
