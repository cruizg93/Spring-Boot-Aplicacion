package com.cristianRuizBlog.aplicacion.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cristianRuizBlog.aplicacion.entity.City;
import com.cristianRuizBlog.aplicacion.entity.Country;


@Repository
public interface CityRepository extends CrudRepository<City, Long>{

	Set<City> findByCountry(Country country);

}
