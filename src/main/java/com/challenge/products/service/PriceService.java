package com.challenge.products.service;

import java.time.LocalDateTime;

import com.challenge.products.dto.PriceDTO;

public interface PriceService extends GenericService<PriceDTO> {

	/**
	 * Find price by params
	 * 
	 * @param startDate the Date start price
	 * @param productId the product id
	 * @param brandId   the brand id
	 * @return PriceDTO
	 */
	PriceDTO findByParams(LocalDateTime startDate, Integer productId, Integer brandId);

}
