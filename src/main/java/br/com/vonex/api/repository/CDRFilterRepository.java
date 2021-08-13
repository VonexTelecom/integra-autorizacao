package br.com.vonex.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.vonex.api.filter.CDRFilter;
import br.com.vonex.api.model.CDR;

public interface CDRFilterRepository {
	
	Page<CDR> find(Pageable pageable, CDRFilter filter);
}
