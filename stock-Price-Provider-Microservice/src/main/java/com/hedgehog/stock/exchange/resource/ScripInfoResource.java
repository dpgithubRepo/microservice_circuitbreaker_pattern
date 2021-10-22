package com.hedgehog.stock.exchange.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hedgehog.stock.exchange.scrip.Scrip;
import com.hedgehog.stock.exchange.service.IScripInfoService;

import lombok.extern.slf4j.Slf4j;


/**
 * The Class ScripInfoResource.
 */
@RestController
@Slf4j
public class ScripInfoResource {
	
	/** The scrip info service. */
	@Autowired
	private IScripInfoService scripInfoService;
	
	/**
	 * Gets the scrip price.
	 *
	 * @param scripId the scrip id
	 * @return the scrip price
	 */
	@GetMapping("/enquire/{scrip}")
	public Scrip getScripPrice(@PathVariable(value = "scrip") Integer scripId) {
		Scrip scrip = scripInfoService.getScripInfo(scripId);
		scrip.setId(scripId);
		return scrip;
	}

	
	@GetMapping("/enquire/circuitBrkr/{scrip}")
	public Scrip getScripPriceCktBrkr(@PathVariable(value = "scrip") Integer scripId) {
		Scrip scrip = scripInfoService.getScripInfo(scripId);
		scrip.setId(scripId);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			log.info("Circuit breaker....");
		}
		
		return scrip;
	}

}
