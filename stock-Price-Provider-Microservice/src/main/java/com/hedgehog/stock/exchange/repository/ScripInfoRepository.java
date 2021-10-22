package com.hedgehog.stock.exchange.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.hedgehog.stock.exchange.scrip.Scrip;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class ScripInfoRepository.
 */
@Repository
@Slf4j
public class ScripInfoRepository implements IScripInfoRepository {
	
	/** The scrip. */
	private static Scrip scrip;
	
	static {
		
		scrip = new Scrip();
		scrip.setAsOfDate(new SimpleDateFormat("MM-dd-yyyy HH:MM:SS").format(new Date()));
		scrip.setRate(new BigDecimal(566.85).setScale(2, RoundingMode.HALF_UP));
		scrip.setT_high(new BigDecimal(555.55).setScale(2, RoundingMode.HALF_UP));
		scrip.setT_low(new BigDecimal(543.70).setScale(2, RoundingMode.HALF_UP));
		scrip.setW52_high(new BigDecimal(642.70).setScale(2, RoundingMode.HALF_UP));
		scrip.setW52_low(new BigDecimal(511.15).setScale(2, RoundingMode.HALF_UP));
		log.info("scip informaton :: {}", scrip);
	}

	/**
	 * Gets the scrip currrent price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip currrent price
	 */
	@Override
	public BigDecimal getScripCurrrentPrice(Integer scripId) {
		return scrip.getRate();
	}

	/**
	 * Gets the scrip day high.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day high
	 */
	@Override
	public BigDecimal getScripDayHigh(Integer scripId) {
		return scrip.getT_high();
	}

	/**
	 * Gets the scrip day low.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day low
	 */
	@Override
	public BigDecimal getScripDayLow(Integer scripId) {
		return scrip.getT_low();
	}

	/**
	 * Gets the script 52 W high.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 W high
	 */
	@Override
	public BigDecimal getScript52WHigh(Integer scripId) {
		return scrip.getW52_high();
	}

	/**
	 * Gets the script 52 low.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 low
	 */
	@Override
	public BigDecimal getScript52Low(Integer scripId) {
		return scrip.getW52_low();
	}

	/**
	 * Gets the scrip info.
	 *
	 * @param scripId the scrip id
	 * @return the scrip info
	 */
	@Override
	public Scrip getScripInfo(Integer scripId) {
		return scrip;
	}

}
