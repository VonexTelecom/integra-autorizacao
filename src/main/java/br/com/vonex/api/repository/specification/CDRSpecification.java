package br.com.vonex.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.vonex.api.model.CDR;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.domain.LikeIgnoreCase;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@And({ 
	@Spec(path = "accountName", params = "name", spec = LikeIgnoreCase.class),
	@Spec(path = "numberTo", params = "number", spec = Like.class),
})
public interface CDRSpecification extends Specification<CDR>{}
