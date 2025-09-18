package com.devsuperior.bds04.service;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {


	private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

	public List<CityDTO> findAll() {
		List<City> list = cityRepository.findAll(Sort.by("name"));
		return list.stream().map(CityDTO::new).toList();
	}

	@Transactional
	public CityDTO insert(CityDTO dto) {
		City entity = new City();
		entity.setName(dto.getName());
		entity = cityRepository.save(entity);
		return new CityDTO(entity);
	}
}
