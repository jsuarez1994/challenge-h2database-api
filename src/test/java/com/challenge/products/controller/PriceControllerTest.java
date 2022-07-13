package com.challenge.products.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.challenge.products.dto.PriceDTO;
import com.challenge.products.service.PriceService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PriceController.class)
public class PriceControllerTest {

	private static final String URI = "/api/prices";

	private static final String PARAMDATE = "date";

	private static final String PARAMPRODUCT = "productId";

	private static final String PARAMPRODUCT_VALUE = "35455";

	private static final String PARAMBRAND = "brandId";

	private static final String PARAMBRAND_VALUE = "1";

	@MockBean
	@Qualifier("priceService")
	PriceService service;

	@Autowired
	MockMvc mockMvc;

	@Test
	@DisplayName("Petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
	public void test1() throws Exception {

		PriceDTO response = new PriceDTO();
		response.setId(1);

		when(service.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		mockMvc.perform(get(URI).param(PARAMDATE, "2020-06-14 10:00:00").param(PARAMPRODUCT, PARAMPRODUCT_VALUE)
				.param(PARAMBRAND, PARAMBRAND_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Petición a las 16:00 del día 14 del producto 35455  para la brand 1 (ZARA)")
	public void test2() throws Exception {

		PriceDTO response = new PriceDTO();
		response.setId(2);

		when(service.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		mockMvc.perform(get(URI).param(PARAMDATE, "2020-06-14 16:00:00").param(PARAMPRODUCT, PARAMPRODUCT_VALUE)
				.param(PARAMBRAND, PARAMBRAND_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)")
	public void test3() throws Exception {

		PriceDTO response = new PriceDTO();
		response.setId(1);

		when(service.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		mockMvc.perform(get(URI).param(PARAMDATE, "2020-06-14 21:00:00").param(PARAMPRODUCT, PARAMPRODUCT_VALUE)
				.param(PARAMBRAND, PARAMBRAND_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Petición a las 16:00 del día 15 del producto 35455  para la brand 1 (ZARA)")
	public void test4() throws Exception {

		PriceDTO response = new PriceDTO();
		response.setId(3);

		when(service.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		mockMvc.perform(get(URI).param(PARAMDATE, "2020-06-15 16:00:00").param(PARAMPRODUCT, PARAMPRODUCT_VALUE)
				.param(PARAMBRAND, PARAMBRAND_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	@DisplayName("Petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)")
	public void test5() throws Exception {

		PriceDTO response = new PriceDTO();
		response.setId(4);

		when(service.findByParams(Mockito.any(), Mockito.any(), Mockito.any())).thenReturn(response);

		mockMvc.perform(get(URI).param(PARAMDATE, "2020-06-16 21:00:00").param(PARAMPRODUCT, PARAMPRODUCT_VALUE)
				.param(PARAMBRAND, PARAMBRAND_VALUE).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	

}