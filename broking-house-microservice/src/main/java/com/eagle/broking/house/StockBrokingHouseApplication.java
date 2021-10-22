package com.eagle.broking.house;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class StockBrokingHouseApplication.
 * @author Durga Prasad
 *
 */

@SpringBootApplication
@Slf4j
public class StockBrokingHouseApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		log.info("in BrokingHouseApplication :: main method");
		SpringApplication.run(StockBrokingHouseApplication.class, args);
	}

}
