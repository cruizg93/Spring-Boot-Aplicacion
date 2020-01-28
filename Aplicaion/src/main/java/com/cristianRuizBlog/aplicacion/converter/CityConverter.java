package com.cristianRuizBlog.aplicacion.converter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.cristianRuizBlog.aplicacion.entity.City;
import com.cristianRuizBlog.aplicacion.repository.CityRepository;

@Component
public class CityConverter implements Converter<String, City>{

	@Autowired
	CityRepository cityRepository;
	
	@Override
	public City convert(String formValue) {
		Long id = Long.parseLong(formValue);
		Optional<City> city = cityRepository.findById(id);
		return city.get();
	}
}
