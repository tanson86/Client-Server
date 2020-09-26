package com.marlabs.solution.clientserver;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestWithoutDummyServer {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void shouldReturnOk() throws Exception {
		this.mockMvc.perform(get("/findDigitsToSum")).andDo(print()).andExpect(status().isOk());
	}
	
	
	@Test
	public void shouldNotReturnOkforVerifySum() throws Exception {
		ClientServerPOJO cp = new ClientServerPOJO();
		int[] a = {1,2,3};
		cp.setDigits(a);
		cp.setSum(3);
		ObjectMapper mapper = new ObjectMapper();
      	String cpAsJSON = mapper.writeValueAsString(cp);
      	
      	this.mockMvc.perform(post("/verifySum")
            	.content(cpAsJSON)	
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest());
	}
	
	@Test
	public void shouldReturnOkForVerifySum() throws Exception {
		ClientServerPOJO cp = new ClientServerPOJO();
		int[] a = {1,2,3};
		cp.setDigits(a);
		cp.setSum(6);
		ObjectMapper mapper = new ObjectMapper();
      	String cpAsJSON = mapper.writeValueAsString(cp);
      	
      	this.mockMvc.perform(post("/verifySum")
            	.content(cpAsJSON)	
                .accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
	}
}
