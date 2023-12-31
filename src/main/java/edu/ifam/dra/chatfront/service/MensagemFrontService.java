package edu.ifam.dra.chatfront.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import edu.ifam.dra.chatfront.model.Contato;
import edu.ifam.dra.chatfront.model.Mensagem;

@Service
public class MensagemFrontService {
	
	private final String url = "http://localhost:8080/mensagem"; 

	public List<Mensagem> getMensagens(){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Mensagem[]> response = restTemplate.getForEntity(
			url , Mensagem[].class);
		return new ArrayList<Mensagem>(Arrays.asList(response.getBody()));
	}
	
	public Mensagem getMensagem(Long id){
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Mensagem> response = restTemplate.getForEntity(
			url + "/" + id.toString(), Mensagem.class);
		return response.getBody();
	}
	
	public Mensagem postMensagem(Mensagem mensagem) {
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Mensagem> requestBody = new HttpEntity<>(mensagem, headers);
		
		ResponseEntity<Mensagem> response = restTemplate.postForEntity(
				url,
				requestBody, Mensagem.class);
		
		return response.getBody();
	}
	
	public void deleteMensagem(long id){
		RestTemplate restTemplate = new RestTemplate();
		String urlDelete = url + "/" + Long.toString(id);
		restTemplate.delete(urlDelete);
	}
}
