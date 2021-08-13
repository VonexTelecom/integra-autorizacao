package br.com.vonex.api.controller.swagger;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.vonex.api.dto.input.CDRInputDto;
import br.com.vonex.api.dto.output.CDROutputDto;
import br.com.vonex.api.exception.handler.Problem;
import br.com.vonex.api.filter.CDRFilter;
import br.com.vonex.api.filter.CDRSpecsFilter;
import br.com.vonex.api.model.CDR;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "Controller de CDR")
public interface CDRControllerSwagger {

	@ApiOperation(value = "Busca todos os CDRs", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = CDR.class, message = "Requisição com sucesso")
	})
	ResponseEntity<Page<CDROutputDto>>findAll(Pageable pageable, CDRFilter filter);
	
	
	@ApiOperation(value = "Busca um único CDR", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = CDR.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> findById(@PathVariable Long id);
	
	@ApiOperation(value = "Retorna uma lista pela pesquisa do nome e numero", httpMethod = "GET")
	@ApiResponses({
		@ApiResponse(code = 200, response = CDR.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	Page<CDR> findByNameAndNumber(CDRSpecsFilter filter, Pageable pageable);
	


	@ApiOperation(value = "Adiciona um novo CDR", httpMethod = "POST")
	@ApiResponses({
		@ApiResponse(code = 200, response = CDR.class, message = "Requisição com sucesso")
	})
	ResponseEntity<CDROutputDto> save (@RequestBody @ApiParam(name="body", value = "Representação de um CCDR") CDRInputDto cdr
			, UriComponentsBuilder uri);
	
	@ApiOperation(value = "Atualiza um CDR", httpMethod = "PUT")
	@ApiResponses({
		@ApiResponse(code = 200, response = CDR.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> update (@RequestBody @ApiParam(name="body", value = "Representação de um CDR") CDRInputDto cdr,
			@PathVariable Long id);
	
	@ApiOperation(value = "Deleta um CDR", httpMethod = "DELETE")
	@ApiResponses({
		@ApiResponse(code = 204, response = CDR.class, message = "Requisição com sucesso"),
		@ApiResponse(code = 404, response = Problem.class, message = "O recurso não foi encontrado")
	})
	ResponseEntity<?> delete(@PathVariable Long id);
}
