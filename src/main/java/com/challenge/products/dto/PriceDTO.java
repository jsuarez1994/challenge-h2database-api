package com.challenge.products.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceDTO {

	private Integer id;

	private Integer productId;

	private Integer brandId;

	private Integer priceList;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private Double price;

}
