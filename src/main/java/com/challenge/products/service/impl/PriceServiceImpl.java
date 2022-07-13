package com.challenge.products.service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.challenge.products.dto.PriceDTO;
import com.challenge.products.entity.PriceEntity;
import com.challenge.products.mapper.PriceMapper;
import com.challenge.products.repository.PriceRepository;
import com.challenge.products.service.PriceService;

import lombok.extern.slf4j.Slf4j;

@Service("priceService")
@Slf4j
public class PriceServiceImpl extends GenericServiceImpl<PriceDTO, PriceEntity, PriceRepository, PriceMapper>
		implements PriceService {

	@Override
	public PriceDTO findByParams(LocalDateTime startDate, Integer productId, Integer brandId) {
		log.info("Init PriceServiceImpl.findByParams");
		List<PriceEntity> prices = repository.findByDateAndProductAndBrand(startDate, productId, brandId);
		PriceDTO response = CollectionUtils.isEmpty(prices) ? null
				: mapper.toDTO(prices.stream().sorted(Comparator.comparing(PriceEntity::getPriority).reversed())
						.findFirst().orElse(null));
		log.info("Finish PriceServiceImpl.findByParams");
		return response;
	}

}
