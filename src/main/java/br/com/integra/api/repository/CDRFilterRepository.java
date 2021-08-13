package br.com.integra.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.integra.api.filter.CDRFilter;
import br.com.integra.api.model.CDR;

public interface CDRFilterRepository {
	
	Page<CDR> find(Pageable pageable, CDRFilter filter);
}
