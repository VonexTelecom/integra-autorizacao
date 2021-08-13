package br.com.integra.api.filter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "CDRSpecsFilter")
public class CDRSpecsFilter {
	
	@ApiModelProperty(value = "Nome do cliente", dataType = "String", example = "samsung")
	private String accountName;
	
	@ApiModelProperty(value = "Numero que recebeu a ligação", dataType = "int", example = "5568999")
	private int numberTo;

}
