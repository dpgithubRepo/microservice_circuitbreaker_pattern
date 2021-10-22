/*
 * 
 */
package com.eagle.broking.house.vo;

import java.math.BigDecimal;

import lombok.Data;



/**
 * The class Scrip
 * 
 * @author Durga Prasad
 *
 */
@Data
public class Scrip {
	
	/** The id. */
	private Integer id;
	
	/** The code. */
	private String code;
	
	/** The name. */
	private String name;
	
	/** The rate. */
	private BigDecimal rate;
	
	/** The t low. */
	private BigDecimal t_low;
	
	/** The t high. */
	private BigDecimal t_high;
	
	/** The w 52 high. */
	private BigDecimal w52_high;
	
	/** The w 52 low. */
	private BigDecimal w52_low; 
	
	/** The as of date. */
	private String asOfDate;
	
	/** The error code. */
	private String errorCode;
	

}
