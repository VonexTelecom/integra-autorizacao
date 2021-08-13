package br.com.vonex.api.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CDR_PROCESSADO_BI", schema = "CDR_BI")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CDR {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID")
	private Long clientId;
	
	@Column(name = "SRC_SETUP_TIME")
	private LocalDateTime setupTime;

	@Column(name = "CDR_DATE")
	private LocalDateTime date;
	
	@Column(name = "SRC_CONNECT_TIME")
	private LocalDateTime connectTime;
	
	@Column(name = "SRC_ALERTING_TIME")
	private LocalDateTime alertTime;
	
	@Column(name = "NUMBER_TO")
	private String numberTo;
	
	@Column(name = "NUMBER_FROM")
	private String numberFrom;
	
	@Column(name = "ELAPSED_TIME")
	private Integer elapsedTime;
	
	@Column(name = "CALLIDPLATAFORMA")
	private String callIdPlataforma;
	
	@Column(name = "CALLID")
	private Integer callId;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "PLATAFORMAID")
	private Integer plataformaId;
	
	@Column(name = "IDENTIFICACAO_CLIENTE_PLATAFORMA")
	private String identificacaoClientePlataforma;

	@Column(name = "ACCOUNT_NAME")
	private String accountName;
	
	@Column(name = "CONFERENCE_ID")
	private String conferenceId;
	
	@Column(name = "DISCONNECT_CODE")
	private Integer disconnectCode;

	@Column(name = "DISCONNECT_CODE_TYPE")
	private String disconnectCodeType;
	
	@Column(name = "SRC_DISCONNECT_CODE")
	private Integer srcDisconnectCode;

	@Column(name = "SRC_DISCONNECT_CODE_TYPE")
	private String srcDisconnectCodeType;
	
	@Column(name = "DST_DISCONNECT_CODE")
	private Integer dstDisconnectCode;

	@Column(name = "DST_DISCONNECT_CODE_TYPE")
	private String dstDisconnectCodeType;
	
	@Column(name = "ROUTE_RETRIES")
	private Integer routeRetries;
	
	@Column(name = "EQUIPMENT_NAME")
	private String equipamentName;
	
	@Column(name = "CLIENT_COST")
	private Integer clientCos;
	
	@Column(name = "CLIENT_TIME")
	private Integer clilentTime;
	
	@Column(name = "ENTRANTE")
	private Integer entrante;
	
	@Column(name = "DISCONNECT_INITIATOR")
	private Integer disconnectInitiator;

}
