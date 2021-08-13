package br.com.vonex.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vonex.api.controller.swagger.CDRControllerSwagger;
import br.com.vonex.api.dto.input.CDRInputDto;
import br.com.vonex.api.dto.output.CDROutputDto;
import br.com.vonex.api.filter.CDRFilter;
import br.com.vonex.api.filter.CDRSpecsFilter;
import br.com.vonex.api.model.CDR;
import br.com.vonex.api.repository.specification.CDRSpecification;
import br.com.vonex.api.service.CDRService;


@RestController
@RequestMapping("/cdr")
public class CDRController implements CDRControllerSwagger{
	
	@Autowired
	private CDRService service;

	@Override
	@GetMapping
	public ResponseEntity<Page<CDROutputDto>> findAll(Pageable pageable, CDRFilter filter){
		return ResponseEntity.ok(service.findAllV2(filter, pageable));
	}
	
	@GetMapping("/spec")
	public ResponseEntity<Page<CDROutputDto>> findAllSpec(CDRSpecification spec, Pageable pageable){
		return ResponseEntity.ok(service.findAllSpec(spec, pageable));
	}
	
	@Override
	@GetMapping("/{id}")
	public ResponseEntity<CDROutputDto> findById(@PathVariable Long id) {
		
		CDROutputDto dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	@GetMapping("/name")
	public Page<CDR> findByNameAndNumber(CDRSpecsFilter filter, Pageable pageable) {
		Page<CDR> dto = service.findByNameAndNumber(filter, pageable);
		return dto;
	}
	
	@Override
	@PostMapping
	public ResponseEntity<CDROutputDto> save (@RequestBody CDRInputDto cdr, UriComponentsBuilder uri) {
		
		CDROutputDto dto = service.save(cdr);
		return ResponseEntity.created(uri.path("/cdr/{id}").buildAndExpand(dto.getClientId()).toUri()).body(dto);
	}
	
	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CDRInputDto cdr, @PathVariable Long id) {
		
		return ResponseEntity.ok(service.update(id, cdr));
	}
}
