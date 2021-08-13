package br.com.vonex.api.repository.filter.impl;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import br.com.vonex.api.filter.CDRFilter;
import br.com.vonex.api.model.CDR;
import br.com.vonex.api.repository.CDRFilterRepository;

@Repository
public class CDRFilterRepositoryImpl implements CDRFilterRepository{
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<CDR> find(Pageable pageable, CDRFilter filter) {
		
		StringBuilder sql  = new StringBuilder("from CDR c where 0 = 0 ");
		Map<String, Object> param = new HashMap<String, Object>();
		
		if(filter.getClientID() != null) {
			System.out.println(filter.getClientID());
			sql.append("and c.clientId = :idclient ");
			param.put("idclient", filter.getClientID());
		}
		
		if(filter.getDataInicial() != null) {
			sql.append("and c.date >= :datainicial ");
			param.put("datainicial", filter.getDataInicial());
		}
		
		if(filter.getDataFinal() != null) {
			sql.append("and c.date <= :datafinal ");
			param.put("datafinal", filter.getDataFinal());
		}
		
		if(filter.getConferenceID() != null) {
			sql.append("and c.conferenceId = :conference ");
			param.put("conference", filter.getConferenceID());
		}
		
		
		TypedQuery<CDR> query = manager.createQuery(sql.toString(), CDR.class);		
		param.forEach((chave, valor) -> query.setParameter(chave, valor));
		
		Long size = Long.valueOf(query.getResultList().size());
		
		query.setFirstResult((int) pageable.getOffset());
		query.setMaxResults(pageable.getPageSize());
		
		Page<CDR> page = new PageImpl<>(query.getResultList(), pageable, size);
		
		return page;
	}

}
