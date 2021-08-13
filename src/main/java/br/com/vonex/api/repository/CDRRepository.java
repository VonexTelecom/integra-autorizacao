package br.com.vonex.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.vonex.api.model.CDR;

@Repository
public interface CDRRepository extends JpaRepository<CDR, Long>,CDRFilterRepository,JpaSpecificationExecutor<CDR> {
	
	CDR findByConferenceId(String conferenceId);
	Optional<CDR> findByClientId(Long clinetId);
}

