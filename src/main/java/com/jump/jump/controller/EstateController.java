package com.jump.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jump.jump.domain.Estate;
import com.jump.jump.dto.EstateDto;
import com.jump.jump.service.EstateService;

import ch.qos.logback.classic.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value="Api")
public class EstateController {
	
	@Autowired
	private EstateService estateService;

	@ApiOperation(value ="Restona uma lista de Imobiliarias")
	@GetMapping("/estate")
	public ResponseEntity<List<Estate>> findAll() {
		return ResponseEntity.ok(this.estateService.findAll());
	}

	@ApiOperation(value ="Restona uma lista de Imobiliarias por CPNJ")
	@GetMapping("/estate/{cnpj}")
	public ResponseEntity<EstateDto> findById(@PathVariable(value = "cnpj") String cnpj) {
		EstateDto dto = this.estateService.findOne(cnpj);
		return ResponseEntity.ok(dto);
	}
	
	@ApiOperation(value ="Restona uma lista de Imobiliarias por CPNJ")
	@PostMapping("/estate/cadastra")
	public Estate create(@RequestBody EstateDto dto) {
		return estateService.save(dto);
	}
	@ApiOperation(value ="Restona uma lista de Imobiliarias por CPNJ")
	@DeleteMapping("/estate/delete/{cnpj}")
	public ResponseEntity<?> delete(@PathVariable(value = "cnpj") String cnpj) {
		estateService.deleteFindbyCnpj(cnpj);
		return ResponseEntity.ok().build();
	}
	@ApiOperation(value ="Restona uma lista de Imobiliarias por CPNJ")
	@PutMapping("/estate/update/{cnpj}")
	public Estate updateController(@PathVariable(value = "cnpj") String cnpj, @RequestBody EstateDto dto) {

		return estateService.update(cnpj, dto);
	}

}
