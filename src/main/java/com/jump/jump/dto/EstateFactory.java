package com.jump.jump.dto;

import org.springframework.stereotype.Service;

import com.jump.jump.domain.Estate;

@Service
public class EstateFactory {
	
	//Cadastra Usando o Padrão DTO 
	public Estate create (EstateDto dto) {
		Estate imobiliaria = new Estate();
		imobiliaria.setTradingName(dto.getTradingName());
		imobiliaria.setTelephone(dto.getTelephone());
		imobiliaria.setCompanyName(dto.getCompanyName());
		imobiliaria.setCnpj(dto.getCnpj());
		return imobiliaria;
				
	}
	


	// Busca utilizando o padrão DTO 
	public EstateDto parse  (Estate estate) {
		EstateDto dto = new EstateDto();
		dto.setTradingName(estate.getTradingName());
		dto.setTelephone(estate.getTelephone());
		dto.setTradingName(estate.getTradingName());
		dto.setCnpj(dto.getCnpj());
		return dto;
	}

}
