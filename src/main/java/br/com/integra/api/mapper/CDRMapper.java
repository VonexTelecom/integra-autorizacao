package br.com.integra.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.integra.api.dto.input.CDRInputDto;
import br.com.integra.api.dto.output.CDROutputDto;
import br.com.integra.api.model.CDR;

@Component
public class CDRMapper {
	
	@Autowired
	private ModelMapper mapper;
	
	public CDROutputDto modelToOutputDto(CDR model) {
		return mapper.map(model, CDROutputDto.class);
	}
	
	public CDR inputDtoToModel(CDRInputDto request) {
		return mapper.map(request, CDR.class);
	}
	
}
