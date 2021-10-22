package com.hedgehog.stock.exchange.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hedgehog.stock.exchange.repository.IScripInfoRepository;
import com.hedgehog.stock.exchange.scrip.Scrip;

/**
 * The Class ScripInfoService.
 * 
 *  @author Durga Prasad
 */
@Service
public class ScripInfoService implements IScripInfoService {

	/** The scrip info repository. */
	@Autowired
	private IScripInfoRepository scripInfoRepository;
	
	/**
	 * Gets the scrip currrent price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip currrent price
	 */
	@Override
	public BigDecimal getScripCurrrentPrice(Integer scripId) {
		return scripInfoRepository.getScripCurrrentPrice(scripId);
	}

	/**
	 * Gets the scrip day high.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day high
	 */
	@Override
	public BigDecimal getScripDayHigh(Integer scripId) {
		return scripInfoRepository.getScripDayHigh(scripId);
	}

	/**
	 * Gets the scrip day low.
	 *
	 * @param scripId the scrip id
	 * @return the scrip day low
	 */
	@Override
	public BigDecimal getScripDayLow(Integer scripId) {
		return scripInfoRepository.getScripDayLow(scripId);
	}

	/**
	 * Gets the script 52 W high.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 W high
	 */
	@Override
	public BigDecimal getScript52WHigh(Integer scripId) {
		return scripInfoRepository.getScript52WHigh(scripId);
	}

	/**
	 * Gets the script 52 low.
	 *
	 * @param scripId the scrip id
	 * @return the script 52 low
	 */
	@Override
	public BigDecimal getScript52Low(Integer scripId) {
		return scripInfoRepository.getScript52Low(scripId);
	}

	/**
	 * Gets the scrip info.
	 *
	 * @param scripId the scrip id
	 * @return the scrip info
	 */
	@Override
	public Scrip getScripInfo(Integer scripId) {
		return scripInfoRepository.getScripInfo(scripId);
	}}
