package com.challenge.products.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import util.Constants;

@Entity
@Table(name = "PRICES")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "BRAND_ID")
	private Integer brandId;

	@Column(name = "START_DATE")
	@DateTimeFormat(pattern = Constants.FORMAR_LOCAL_DATE_TIME)
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	@DateTimeFormat(pattern = Constants.FORMAR_LOCAL_DATE_TIME)
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceList;

	@Column(name = "PRODUCT_ID")
	private Integer productId;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "CURR")
	private String curr;

}
