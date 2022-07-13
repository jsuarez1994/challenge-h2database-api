package com.challenge.products.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.products.dto.PriceDTO;
import com.challenge.products.service.PriceService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("${endpoints.main}")
@Slf4j
public class PriceController {

	/** the service */
	@Qualifier("priceService")
	private PriceService service;

	/**
	 * 
	 * Constructor
	 * 
	 * @param service the PriceService
	 */
	public PriceController(PriceService service) {
		this.service = service;
	}

	/**
	 * @param date      the Start date
	 * @param productId the product Id
	 * @param brandId   the brand id
	 * @return
	 */
	@Operation(summary = "Get a result of price")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Result operation", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = PriceDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid operator", content = @Content),
			@ApiResponse(responseCode = "404", description = "Invalid operator", content = @Content) })
	@GetMapping(path = "${endpoints.prices}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> result(
			@RequestParam(name = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date,
			@RequestParam Integer productId, @RequestParam Integer brandId) {
		log.info("Start PriceController.result");
		ResponseEntity<Object> response = null;
		try {
			response = new ResponseEntity<Object>(service.findByParams(date, productId, brandId), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error: {}", e.getMessage());
			response = new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		log.info("End PriceController.result");
		return response;
	}

}
