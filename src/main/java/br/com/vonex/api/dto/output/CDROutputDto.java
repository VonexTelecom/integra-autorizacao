package br.com.vonex.api.dto.output;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CDROutputDto {
	
	private Long clientId;
	
	private LocalDateTime setupTime;
	
	private LocalDateTime date;
	
	private LocalDateTime connectTime;
	
	private LocalDateTime alertTime;
	
	private String numberTo;
	
	private String numberFrom;
	
	private Integer elapsedTime;
	
	private String callIdPlataforma;
	
	private Integer callId;
	
	private Integer status;
	
	private Integer plataformaId;
	
	private String identificacaoClientePlataforma;

	private String accountName;
	
	private String conferenceId;
	
	private Integer disconnectCode;

	private String disconnectCodeType;
	
	private Integer srcDisconnectCode;

	private String srcDisconnectCodeType;
	
	private Integer dstDisconnectCode;

	private String dstDisconnectCodeType;
	
	private Integer routeRetries;
	
	private String equipamentName;
	
	private Integer clientCos;
	
	private Integer clilentTime;
	
	private Integer entrante;
	
	private Integer disconnectInitiator;

	
}
