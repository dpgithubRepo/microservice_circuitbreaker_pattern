package com.hedgehog.stock.exchange.interceptors;

import java.util.Random;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.hedgehog.stock.exchange.scrip.Scrip;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class HedgeHogExchangeResposeAdvice.
 */
@ControllerAdvice
@Slf4j
public class HedgeHogExchangeResposeAdvice implements ResponseBodyAdvice<Scrip> {

	/**
	 * Supports.
	 *
	 * @param returnType the return type
	 * @param converterType the converter type
	 * @return true, if successful
	 */
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	/**
	 * Before body write.
	 *
	 * @param body the body
	 * @param returnType the return type
	 * @param selectedContentType the selected content type
	 * @param selectedConverterType the selected converter type
	 * @param request the request
	 * @param response the response
	 * @return the scrip
	 */
	@Override
	public Scrip beforeBodyWrite(Scrip body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
					ServerHttpResponse response) {
		log.info("in beforeBodyWrite method of :: HedgeHogExchangeResponseAdvice");
		
		if(body instanceof Scrip) {
			Scrip scrip = (Scrip)body;
			String[] scrips = {"rels","nsex","cdil","icrtrc","tomato","croos","provog","babramdos"};
			String info = scrips[new Random().nextInt(7)];
			log.info("Scrip info :: {}", info);
			scrip.setName(info);
			scrip.setCode("HOG "+info);
			log.info("scip informaton after advice :: {}", scrip);
			return scrip;
		}
		return null;
	}

}
