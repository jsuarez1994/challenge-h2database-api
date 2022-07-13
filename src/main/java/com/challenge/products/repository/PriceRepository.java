package com.challenge.products.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.products.entity.PriceEntity;

@Repository("priceRepository")
public interface PriceRepository extends CrudRepository<PriceEntity, Integer> {

	@Query("select a from PriceEntity a where a.startDate <= :date and a.endDate >= :date and a.productId = :product and a.brandId = :brand")
	List<PriceEntity> findByDateAndProductAndBrand(@Param("date") LocalDateTime date,
			@Param("product") Integer productId, @Param("brand") Integer brandId);

}
