package com.eagle.broking.house.service;

import com.eagle.broking.house.vo.Scrip;

/**
 * The Interface IStockBrokerHousePricingService.
 */
public interface IStockBrokerHousePricingService {

	/**
	 * Gets the scrip price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip price
	 */
	public Scrip getScripPrice(Integer scripId);
	
	/**
	 * Gets the scrip price ckt brkr.
	 *
	 * @param scripId the scrip id
	 * @return the scrip price ckt brkr
	 */
	public Scrip getScripPriceCktBrkr(Integer scripId);
	
	
	public Scrip getScripPriceCktBrkrServiceUnavail(Integer scripId);
}
