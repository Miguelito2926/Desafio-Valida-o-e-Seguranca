package com.devsuperior.bds04.controller;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;



@RestController
@RequestMapping(value = "/cities")
public class CityController {


	private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
	public ResponseEntity<List<CityDTO>> findAll() {
		return ResponseEntity.ok().body(cityService.findAll());
	}

	@PostMapping
	public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto) {
		dto = cityService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
