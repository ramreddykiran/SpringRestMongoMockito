package com.pkrm.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.pkrm.builders.UserBuilder;
import com.pkrm.domain.Example;
import com.pkrm.domain.User;
import com.pkrm.service.RegisterFormService;
import com.pkrm.util.UserUtils;

import static org.mockito.Mockito.verify;

/**
 * 
 * @author kramreddy
 *This test class contains test cases 
 *by calling API for both GET(with request params) and POST (passing request body) operations
 *and control methods
 *included static methods mocking, verifying the results with ArgumentCaptor
 */
@PrepareForTest(UserUtils.class)
@RunWith(PowerMockRunner.class)
public class RegisterFormControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private RegisterFormController controller;
	
	@Mock
	private RegisterFormService service;
	
	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
					.build();
	}
	
	@Test
	public void shouldReceiveUserDetails() {
		String userId="1234";
		User user = new UserBuilder().withUserId(userId).build();
		when(service.retrieveUserDetails(userId)).thenReturn(user);
		PowerMockito.mockStatic(UserUtils.class);
		PowerMockito.when(UserUtils.convertNameToUpperCase(anyString())).thenReturn("name");
		
		ResponseEntity<?> response = controller.getUserDetails(userId);
		
		assertSame(user, response.getBody());
		assertEquals(HttpStatus.OK,  response.getStatusCode());
	}
	
	@Test
	public void shouldSaveUserDetails() throws Exception {
		Gson gson = new Gson();
		String userJson = gson.toJson(new UserBuilder().build());
		mockMvc.perform(post("/save-employee")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJson))
				.andExpect(status().isOk());
	}
	
	@Test
	public void shouldGetHttpResponseNotFound_WhenUserDetailsAreNotPresent() throws Exception{
		mockMvc.perform(get("/user-details")
						.param("user-id", "12321"))
						.andExpect(status().isNotFound())
						.andReturn().getResponse();
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(service).retrieveUserDetails(captor.capture());
		assertEquals("12321", captor.getValue());
	}
	
	@Test
	public void shouldGetUserDetailsForUserId() throws Exception{
		User user = new UserBuilder().build();
		when(service.retrieveUserDetails(anyString())).thenReturn(user);
		MockHttpServletResponse response = mockMvc.perform(get("/user-details")
						.param("user-id", "12321"))
						.andExpect(status().isOk())
						.andReturn().getResponse();
		Gson gson = new Gson();
		assertEquals(gson.toJson(user), response.getContentAsString());
	}
	
	@Test
	public void sholdReturnHttpStatusNotFoundWhenExampleNotFound() throws Exception {
		mockMvc.perform(get("/retrieve/dept1"))
				.andExpect(status().isNotFound());
	}
	
	@Test
	public void shouldReturnExampleDetails() throws Exception{
		Example example = new Example();
		when(service.getEmp(anyString())).thenReturn(example);
		MockHttpServletResponse response = mockMvc.perform(get("/retrieve/department1"))
						.andExpect(status().isOk())
						.andReturn().getResponse();
		Gson gson = new Gson();
		Example resposneEx = gson.fromJson(response.getContentAsString(), Example.class);
		
		assertEquals(example.getDbl(), resposneEx.getDbl());
		
	}
	
}
