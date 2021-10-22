package com.hedgehog.stock.exchange.service;

import java.math.BigDecimal;

import com.hedgehog.stock.exchange.scrip.Scrip;

/**
 * The Interface IScripInfoService.
 * 
 *  @author Durga Prasad
 */
public interface IScripInfoService {

	/**
	 * Gets the scrip currrent price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip currrent price
	 */
	public BigDecimal getScripCurrrentPrice(Integer scripId);
	
	/**
	 * Gets the scrip day high.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day high
	 */
	public BigDecimal getScripDayHigh(Integer scripId);
	
	/**
	 * Gets the scrip day low.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day low
	 */
	public BigDecimal getScripDayLow(Integer scripId);
	
	/**
	 * Gets the script 52 W high.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 W high
	 */
	public BigDecimal getScript52WHigh(Integer scripId);
	
	/**
	 * Gets the script 52 low.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 low
	 */
	public BigDecimal getScript52Low(Integer scripId);
	
	/**
	 * Gets the scrip info.
	 *
	 * @param scripId the scrip id
	 * @return the scrip info
	 */
	public Scrip getScripInfo(Integer scripId);
	
}
