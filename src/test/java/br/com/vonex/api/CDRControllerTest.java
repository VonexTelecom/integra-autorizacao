package br.com.vonex.api;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.integra.api.exception.EntidadeNaoEncontradaException;
import br.com.integra.api.model.CDR;
import br.com.integra.api.repository.CDRRepository;
import br.com.integra.api.service.CDRService;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CDRControllerTest {
	
	    @Autowired
	    private MockMvc mockMvc;
	    
	    @Autowired
	    CDRRepository CDRRepository;
	    
	    @Autowired
	    CDRService service;
	   
	    @Before
	    public void init() {
	        MockitoAnnotations.initMocks(this);
	    }
	    
	    @Test
	    public void salvarCDRSucesso() throws Exception {
	    			CDR cdr = CDR.builder()
	    	    	.clientId(62793L)
	    	    	.accountName("Banco CSF SA - E1 - Especial Nova - Atento - ADD -  45883")
	    	    	.alertTime(LocalDateTime.of(2021,07,02, 14, 7,39))
	    	    	.callId(690993615)
	    	    	.callIdPlataforma("09898765116252456560008106")
	    	    	.clientCos(0)
	    	    	.clilentTime(0)
	    	    	.conferenceId("0988023503d6db5811ebb6af5cf9ddb44ea8")
	    	    	.connectTime(LocalDateTime.of(2021,07,02, 14, 8,2))
	    	    	.date(LocalDateTime.of(2021,07,02, 14,8,2))
	    	    	.disconnectCode(10)
	    	    	.disconnectCodeType("TS")
	    	    	.disconnectInitiator(1)
	    	    	.dstDisconnectCode(16)
	    	    	.dstDisconnectCodeType("Q850")
	    	    	.elapsedTime(1)
	    	    	.entrante(0)
	    	    	.equipamentName("Banco CSF SA - E1 - Especial Nova - Atento - 45883 - E1 19")
	    	    	.identificacaoClientePlataforma("208062")
	    	    	.numberFrom("0000")
	    	    	.numberTo("5511993391280")
	    	    	.plataformaId(1)
	    	    	.routeRetries(1)
	    	    	.setupTime(LocalDateTime.of(2021,07,02, 14, 7,36))
	    	    	.srcDisconnectCode(16)
	    	    	.srcDisconnectCodeType("Q850")
	    	    	.status(1)
	    	    	.build();
	    			
	    			CDR newCdr = CDRRepository.save(cdr);
	    			
	    			assertThat(newCdr).isNotNull();
	    }
	    
	    @Test
	    public void atualizarCDRSucesso() throws Exception {
	    	
	    	
			CDR cdr = CDRRepository.findByClientId(1234L).get();
			
			cdr.setAccountName("novo nome");
	    	CDRRepository.save(cdr);
	    	cdr = CDRRepository.findByClientId(1234L).get();

	    	assertThat(cdr.getAccountName()).isEqualTo("novo nome");
	    	
	    }
	    
	   @Test
	    public void deletarCDRSucesso() throws Exception {

	   		
	   	  Optional<CDR> newCdr= CDRRepository.findByClientId(1234L);

	      CDRRepository.delete(newCdr.get());
	      newCdr= CDRRepository.findByClientId(1234L);
	      
	      assertThat(newCdr.isPresent()).isFalse();
	   }
	   

	    

	    @Test
	    public void buscarSucesso() throws Exception {
	    	
	    	CDR cdr = CDR.builder()
	    	.clientId(62793L)
	    	.accountName("Banco CSF SA - E1 - Especial Nova - Atento - 45883")
	    	.alertTime(LocalDateTime.of(2021,07,02, 14, 7,39))
	    	.callId(690993615)
	    	.callIdPlataforma("116252456560008106")
	    	.clientCos(0)
	    	.clilentTime(62793)
	    	.conferenceId("000003d6db5811ebb6af5cf9ddb44ea8")
	    	.connectTime(LocalDateTime.of(2021,07,02, 14, 8,2))
	    	.date(LocalDateTime.of(2021,07,02, 14,8,2))
	    	.disconnectCode(10)
	    	.disconnectCodeType("TS")
	    	.disconnectInitiator(1)
	    	.dstDisconnectCode(16)
	    	.dstDisconnectCodeType("Q850")
	    	.elapsedTime(1)
	    	.entrante(0)
	    	.equipamentName("Banco CSF SA - E1 - Especial Nova - Atento - 45883 - E1 19")
	    	.identificacaoClientePlataforma("208062")
	    	.numberFrom("0000")
	    	.numberTo("5511993391280")
	    	.plataformaId(1)
	    	.routeRetries(1)
	    	.setupTime(LocalDateTime.of(2021,07,02, 14, 7,36))
	    	.srcDisconnectCode(16)
	    	.srcDisconnectCodeType("Q850")
	    	.status(1)
	    	.build();
	   
	    	
	    	CDR cdrDB = CDRRepository.findByConferenceId("000003d6db5811ebb6af5cf9ddb44ea8");
	    	
	    	assertThat(cdr).isEqualTo(cdrDB);
	    }

}
