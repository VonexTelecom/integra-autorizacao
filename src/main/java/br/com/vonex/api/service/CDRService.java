package br.com.vonex.api.service;

import static br.com.vonex.api.model.CDRSpecifications.hasCDRDate;
import static br.com.vonex.api.model.CDRSpecifications.hasClientId;
import static br.com.vonex.api.model.CDRSpecifications.hasConferenceId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.vonex.api.dto.input.CDRInputDto;
import br.com.vonex.api.dto.output.CDROutputDto;
import br.com.vonex.api.exception.EntidadeNaoEncontradaException;
import br.com.vonex.api.filter.CDRFilter;
import br.com.vonex.api.filter.CDRSpecsFilter;
import br.com.vonex.api.mapper.CDRMapper;
import br.com.vonex.api.model.CDR;
import br.com.vonex.api.repository.CDRRepository;
import br.com.vonex.api.repository.specification.CDRSpecification;
import br.com.vonex.api.repository.specification.CDRSpecs;

@Service
public class CDRService {
	
	@Autowired(required = true)
	private CDRRepository repository;
	
	@Autowired
	private CDRMapper mapper;
	
	@Transactional
	public CDROutputDto save(CDRInputDto cdr) {
		
		CDR savedModel = repository.save(mapper.inputDtoToModel(cdr));
		
		return mapper.modelToOutputDto(savedModel);
	}

	public Page<CDROutputDto> findAll(CDRFilter filter, Pageable pageable){
		
		Page<CDR> page =  repository.find(pageable, filter);
		return page.map(cdr -> mapper.modelToOutputDto(cdr));
	}
	
	public Page<CDROutputDto> findAllSpec(CDRSpecification spec, Pageable pageable){		
		Page<CDR> page =  repository.findAll(spec, pageable);		
		return page.map(cdr -> mapper.modelToOutputDto(cdr));
	}

	public Page<CDR> findByNameAndNumber(CDRSpecsFilter filter, Pageable pageable){
		Page<CDR> listaComNomesELigacoes =  repository.findAll(CDRSpecs.comNomeSemelhante(filter.getAccountName()).and(CDRSpecs.listaDeLigacoesNumber(filter.getNumberTo())),pageable);
		return listaComNomesELigacoes;
	}

	@SuppressWarnings("serial")
	public CDROutputDto findById(Long id){
		
		CDR model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O CDR de ID: "+id+" Não foi encontrado"){});
		
		return mapper.modelToOutputDto(model);
	}
	
	@SuppressWarnings("serial")
	@Transactional
	public CDROutputDto update(Long id, CDRInputDto request) {
		
		CDR model = repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O CDR de ID: "+id+" Não foi encontrado"){});
		BeanUtils.copyProperties(request, model, "id");
		
		return mapper.modelToOutputDto(repository.save(model));
	}
	
	@SuppressWarnings("serial")
	@Transactional
	public void delete(Long id) {
		
		repository.findById(id).orElseThrow(() -> new  EntidadeNaoEncontradaException("O CDR de ID: "+id+" Não foi encontrado"){});
		repository.deleteById(id);
	}
	
	public Page<CDROutputDto> findAllV2(CDRFilter filter, Pageable pageable){
		
		Page<CDR> page = repository.findAll(hasClientId(filter.getClientID()).and(hasConferenceId(filter.getConferenceID()).and(hasCDRDate(filter.getDataInicial(), filter.getDataFinal()))), pageable);
		return page.map(cdr -> mapper.modelToOutputDto(cdr));
	}


}
