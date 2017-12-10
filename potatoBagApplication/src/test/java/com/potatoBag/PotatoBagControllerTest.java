package com.potatoBag;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.potatoBag.controller.PotatoBagController;
import com.potatoBag.domain.Bag;
import com.potatoBag.service.PotatoBagServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PotatoBagController.class, secure = false)
public class PotatoBagControllerTest {
	
	private final static Logger LOGGER = Logger.getLogger(PotatoBagControllerTest.class);
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PotatoBagServiceImpl potatoBagServiceImpl;
    
	@Test
	public void testGetBagList(){
		
		Bag mockBag = new Bag("a7ceea32-6bf5-4717-87cb-c901f5401758",20, "de coster",1512913194729L,20);
		String expectedBagJson = "[{\"bagId\": \"a7ceea32-6bf5-4717-87cb-c901f5401758\","
				          + "\"potatoCount\": 20,\"supplier\": \"de coster\",\"creationdate\": 1512913194729, \"price\": 20 }]";
		List<Bag> bagList = new ArrayList<>();
		bagList.add(mockBag);
		Mockito.when(potatoBagServiceImpl.getBagList(Mockito.anyInt())).thenReturn(bagList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getBags?count=1").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();

			JSONAssert.assertEquals(expectedBagJson, result.getResponse()
					.getContentAsString(), false);
			
		} catch (Exception e) {
			LOGGER.equals("Error Occurred during execution of testGetBagList test case"+ e.getMessage());
		}
	}

	@Test
	public void testAddBag() {
		String expectedBagJson = "[{\"bagId\": \"a7ceea32-6bf5-4717-87cb-c901f5401758\","
		          + "\"potatoCount\": 20,\"supplier\": \"de coster\",\"creationdate\": 1512913194729, \"price\": 20 }]";
		
	    Mockito.when(potatoBagServiceImpl.addBag(Mockito.any(Bag.class))).thenReturn("success");
	    
	    RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/addBag")
				.accept(MediaType.APPLICATION_JSON).content(expectedBagJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result;
		try {
			result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());
			assertEquals("http://localhost/addBag",
					response.getHeader(HttpHeaders.LOCATION));
			
		} catch (Exception e) {
			LOGGER.equals("Error Occurred during execution of testAddBag test case"+ e.getMessage());
		}	
	}
}
