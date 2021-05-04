package com.jump.jump.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jump.jump.domain.Estate;
import com.jump.jump.dto.EstateDto;
import com.jump.jump.dto.EstateFactory;
import com.jump.jump.repository.EstateRepository;


@Service
public class EstateService {
	
	private EstateRepository estateRepository;
	private EstateFactory estateFactory;
	
	public EstateService(EstateRepository estateRepository, EstateFactory estateFactory) {
		this.estateRepository = estateRepository;
		this.estateFactory = estateFactory;
	}

	public Estate save(EstateDto imobiliariaDto){
		Estate imobiliaria = estateFactory.create(imobiliariaDto);
		return this.estateRepository.save(imobiliaria);
	}
	

	public List<Estate> findAll(){
		return this.estateRepository.findAll();
	}
	
	
	public EstateDto findOne (String cnpj) {
		String bal = cnpj;
		Estate imobialiara = this.estateRepository.findByCnpj(bal);
		EstateDto dto = estateFactory.parse(imobialiara);
		return dto;
	} 
	
	public void deleteFindbyCnpj(String cnpj) {
		Estate imobialiara = this.estateRepository.findByCnpj(cnpj);
		long i = imobialiara.getId();
		this.estateRepository.deleteById(i);
		
	} 
	

	public Estate update (String cnpj,EstateDto imobiliariaDto) {
		Estate imobialiara = this.estateRepository.findByCnpj(cnpj);
		imobialiara.setTelephone(imobiliariaDto.getTelephone());
		imobialiara.setCompanyName(imobiliariaDto.getCompanyName());
		imobialiara.setCnpj(imobiliariaDto.getCnpj());
		imobialiara.setTradingName(imobiliariaDto.getTradingName());
		
		return this.estateRepository.save(imobialiara);
	} 
}
