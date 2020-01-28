package com.cristianRuizBlog.aplicacion.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cristianRuizBlog.aplicacion.dto.CityField;
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
				Set<City> cities = cityRepository.findByCountry(country.get());
				return new ResponseEntity<Set<City>>(cities, HttpStatus.OK);
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@GetMapping("/loadCity/{cityID}")
	public ResponseEntity getCity(@PathVariable(name ="cityID")Long cityID) {
		try {
			Optional<City> city = cityRepository.findById(cityID);
			
			if (city.isPresent())
			{
				Long countryID = city.get().getCountry().getId();
				CityField field = new CityField(countryID, cityID);
				
				return new ResponseEntity<CityField>(field, HttpStatus.OK);
			}else {
				return ResponseEntity.noContent().build();
			}
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
