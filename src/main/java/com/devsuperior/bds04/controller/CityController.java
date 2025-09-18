package com.devsuperior.bds04.controller;

import java.net.URI;
import java.util.List;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.service.CityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
@RequestMapping(value = "/cities")
public class CityController {


	private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
//
    @GetMapping
	public ResponseEntity<List<CityDTO>> findAll() {
		return ResponseEntity.ok().body(cityService.findAll());
	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<CityDTO> findById(@PathVariable Long id) {
//		CityDTO dto = cityService.findById(id);
//		return ResponseEntity.ok().body(dto);
//	}

	@PostMapping
	public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto) {
		dto = cityService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<CityDTO> update(@PathVariable Long id, @RequestBody CityDTO dto) {
//		dto = cityService.update(id, dto);
//		return ResponseEntity.ok().body(dto);
//	}

//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Void> delete(@PathVariable Long id) {
//		cityService.delete(id);
//		return ResponseEntity.noContent().build();
//	}
}
