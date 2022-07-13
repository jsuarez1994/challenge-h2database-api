package com.challenge.products.mapper;

import org.mapstruct.Mapper;

import com.challenge.products.dto.PriceDTO;
import com.challenge.products.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper extends GenericMapper<PriceEntity, PriceDTO> {
}
