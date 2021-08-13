package br.com.vonex.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.vonex.api.model.CDR;

//@And({ 
//	@Spec(path = "accountName", params = "accountName", spec = LikeIgnoreCase.class),
//	@Spec(path = "numberTo", params = "numberTo", spec = LikeIgnoreCase.class),
//})
public class CDRSpecs{
	
	public static Specification<CDR> comNomeSemelhante(String accountName){
		return (root, query, builder) -> builder
				.like(root.get("accountName"), "%" + accountName +"%");
	}
	public static Specification<CDR> listaDeLigacoesNumber(int numberTo){
		return (root, query, builder) -> builder.like(root.get("numberTo"), "%" + numberTo +"%");
	}
	

}
