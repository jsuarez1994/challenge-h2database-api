package com.challenge.products.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.util.CollectionUtils;

import com.challenge.products.mapper.GenericMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase abstracta con metodos genericos
 * 
 * @author jslopez
 *
 * @param <D> dto
 * @param <E> document
 * @param <R> repository
 * @param <M> mapper
 */
@Slf4j
@Data
public class GenericServiceImpl<D, E, R extends CrudRepository<E, Integer>, M extends GenericMapper<E, D>> {

	/** the repository */
	@Autowired
	protected R repository;

	/** the mapper */
	@Autowired
	protected M mapper;

	/**
	 * Obtenemos todos los elementos del repositorio asociado
	 * 
	 * @return List DTO
	 */
	public List<D> findAll() {
		log.info("Inicio AbstractServiceImpl.findAll");
		final List<E> list = (List<E>) repository.findAll();
		log.info("Fin findAll AbstractServiceImpl");
		return CollectionUtils.isEmpty(list) ? new ArrayList<>() : mapper.toDTO(list);
	}

	/**
	 * Obtenemos dato por id
	 * 
	 * @param id the id
	 * @return DTO dto
	 */
	public D findById(Integer id) {
		log.info("Inicio AbstractServiceImpl.findById, param: {}", id);
		Optional<E> optData = repository.findById(id);
		log.info("Fin AbstractServiceImpl.findById");
		return optData.isPresent() ? mapper.toDTO(optData.get()) : null;
	}

	/**
	 * Obtenemos dato por lista id
	 * 
	 * @param ids the id
	 * @return List DTO dtos
	 */
	public List<D> findById(List<Integer> ids) {
		log.info("Inicio AbstractServiceImpl.findById, param: {} ids", ids.size());
		final List<E> list = (List<E>) repository.findAllById(ids);
		log.info("Fin AbstractServiceImpl.findById");
		return CollectionUtils.isEmpty(list) ? new ArrayList<>() : mapper.toDTO(list);
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param param the DTO
	 * @return same DTO
	 */
	@Transactional
	public D save(D param) {
		log.info("Inicio AbstractServiceImpl.save: {}", param);
		repository.save(mapper.toEntity(param));
		log.info("Fin AbstractServiceImpl.save");
		return param;
	}

	/**
	 * Guardamos el DTO psasado por parametros
	 * 
	 * @param params the DTO
	 * @return same DTO
	 */
	@Transactional
	public List<D> save(List<D> params) {
		log.info("Inicio AbstractServiceImpl.save List<DTO>");
		repository.saveAll(mapper.toEntity(params));
		log.info("Fin AbstractServiceImpl.save List<DTO>");
		return params;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param param the DTO
	 * @return same DTO
	 */
	@Transactional
	public D delete(D param) {
		log.info("Inicio AbstractServiceImpl.delete: {}", param);
		repository.delete(mapper.toEntity(param));
		log.info("Fin AbstractServiceImpl.delete");
		return param;
	}

	/**
	 * Eliminamos el DTO psasado por parametros
	 * 
	 * @param params the DTO
	 * @return same List DTO
	 */
	@Transactional
	public List<D> delete(List<D> params) {
		log.info("Inicio AbstractServiceImpl.delete List<DTO>");
		repository.deleteAll(mapper.toEntity(params));
		log.info("Fin AbstractServiceImpl.delete List<DTO>");
		return params;
	}

	/**
	 * Eliminamos elemento by id
	 * 
	 * @param id the id
	 * @return same id
	 */
	@Transactional
	public Integer delete(Integer id) {
		log.info("Inicio AbstractServiceImpl.delete, param: {}", id);
		repository.deleteById(id);
		log.info("Fin AbstractServiceImpl.delete");
		return id;
	}

}