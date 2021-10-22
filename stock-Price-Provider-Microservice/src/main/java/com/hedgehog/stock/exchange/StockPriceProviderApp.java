package com.hedgehog.stock.exchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j

/**
 * The Class StockPriceProviderApp.
 * 
 * @author Durga Prasad
 *
 */
public class StockPriceProviderApp {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		log.info("in StockPriceProviderApp ::  main method");
		SpringApplication.run(StockPriceProviderApp.class, args);
	}

}
