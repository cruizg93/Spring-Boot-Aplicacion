package com.cristianRuizBlog.aplicacion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristianRuizBlog.aplicacion.entity.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long>{

	List<Country> findAllByOrderByNameAsc();
	List<Country> findAllByOrderByCodeAsc();
}
