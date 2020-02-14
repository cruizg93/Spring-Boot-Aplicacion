package com.cristianRuizBlog.aplicacion.controller;

import java.util.Optional;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cristianRuizBlog.aplicacion.entity.City;
import com.cristianRuizBlog.aplicacion.entity.Country;
import com.cristianRuizBlog.aplicacion.repository.CityRepository;
import com.cristianRuizBlog.aplicacion.repository.CountryRepository;

@Controller
@RequestMapping("/dropList")
public class DroplistController {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	
	@GetMapping("/loadCities/{countryID}")
	public ResponseEntity getCities(@PathVariable(name ="countryID")Long countryID) {
		try {
			Optional<Country> country = countryRepository.findById(countryID);
			if (country.isPresent())
			{
				Hibernate.initialize(country.get().getCities());
				Set<City> cities = country.get().getCities();
				
				ResponseEntity<Set<City>> result = new ResponseEntity<Set<City>>(cities, HttpStatus.OK); 
				return result;
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}