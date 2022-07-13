package com.challenge.products.mapper;

import java.util.List;

public interface GenericMapper<E, D> {

	D toDTO(E entity);

	List<D> toDTO(List<E> listEntity);

	E toEntity(D dto);

	List<E> toEntity(List<D> listDTO);

}
