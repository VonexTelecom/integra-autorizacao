package br.com.integra.api.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

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
@ApiModel(value = "CDRFilter")
public class CDRFilter {
	
	@ApiModelProperty(value = "ID do cliente", dataType = "Long", example = "62793")
	private Long clientID;
	
	@ApiModelProperty(value = "ID da conferencia", dataType = "String", example = "000003d6db5811ebb6af5cf9ddb44ea8")
	private String conferenceID;
	
	@ApiModelProperty(value = "Data de Início", dataType = "LocalDateTime", example = "2021-07-02T14:07:36")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataInicial;
	
	@ApiModelProperty(value = "Data Final", dataType = "LocalDateTime", example = "2021-07-02T14:07:39")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime dataFinal;
}
