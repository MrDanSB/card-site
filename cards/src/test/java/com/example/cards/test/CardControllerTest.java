package com.example.cards.test;

import java.io.File;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.cards.entity.Card;
import com.example.cards.repository.CardRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class CardControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	CardRepository repository;
	
	@Test
	@WithMockUser(username = "consumerAdm", password = "admin12345", authorities = {"ROLE_ADMIN"})
	void test() throws Exception {
		// Creating temp card for testing
		File test = new File("assets/veloster.jpg");
		byte[] array = FileUtils.readFileToByteArray(test);
		String encodedString = Base64.getEncoder().encodeToString(array);
			
		String json = "{\"cardid\": \"\",\"marca\": \"Hyundai\",\"modelo\": \"Veloster\",\"maixmokmh\": 1500,\"cv\": 20,\"tmin\": 500,\"cc\": 1000,\"clilindros\": 8,\"kg\": 1200,\"image\": \""+encodedString+"\",\"createdate\": \"2021-08-28T05:00:00.000+00:00\"}";
		
		RequestBuilder request1 = MockMvcRequestBuilders.post("/rest/cards").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
		MvcResult result1 = mockMvc.perform(request1).andReturn();
		
		json = result1.getResponse().getContentAsString();
		
		Card card = new ObjectMapper().readValue(json, Card.class);
		
		Assertions.assertEquals("Veloster", card.getModelo());
				
		// UPDATE
		Long idtmp = card.getCardid();
		
		json = "{\"cardid\": \"" + idtmp + "\",\"marca\": \"Hyundai\",\"modelo\": \"Venue\",\"maixmokmh\": 1500,\"cv\": 20,\"tmin\": 500,\"cc\": 1000,\"clilindros\": 8,\"kg\": 1200,\"image\": \""+encodedString+"\",\"createdate\": \"2021-08-28T05:00:00.000+00:00\"}";
		
		RequestBuilder request2 = MockMvcRequestBuilders.put("/rest/cards/{id}",idtmp).sessionAttr("card",card).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json);
		MvcResult result2 = mockMvc.perform(request2).andReturn();
		
		json = result2.getResponse().getContentAsString();
		
		card = new ObjectMapper().readValue(json, Card.class);
		
		Assertions.assertEquals("Venue", card.getModelo());
		
		System.out.println("Ahora soy un " + card.getModelo());
		
		// SELECT 
		RequestBuilder request3 = MockMvcRequestBuilders.get("/rest/cards/{id}",7l);
		MvcResult result3 = mockMvc.perform(request3).andReturn();
		
		json = result3.getResponse().getContentAsString();
		
		card = new ObjectMapper().readValue(json, Card.class);
		
		Assertions.assertEquals("Accent", card.getModelo());
		
		// DELETE
		
		RequestBuilder request5 = MockMvcRequestBuilders.delete("/rest/cards/{id}",idtmp);
		mockMvc.perform(request5);
		
		RequestBuilder request6 = MockMvcRequestBuilders.get("/rest/cards/{id}", idtmp);
		MvcResult result6 = mockMvc.perform(request6).andReturn();
		
		System.out.println("El resultado del Delete es: " + result6.getResponse().getContentAsString());
		
		// SELECT ALL
		RequestBuilder request4 = MockMvcRequestBuilders.get("/rest/cards").param("page", "3");
		MvcResult result7 = mockMvc.perform(request4).andReturn();
			
		System.out.println(result7.getResponse().getContentAsString());
		
	}

}
