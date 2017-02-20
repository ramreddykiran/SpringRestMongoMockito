package com.pkrm.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Matchers.anyString;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pkrm.builders.UserBuilder;
import com.pkrm.domain.User;
import com.pkrm.service.RegisterFormService;
import com.pkrm.util.UserUtils;

@PrepareForTest(UserUtils.class)
@RunWith(PowerMockRunner.class)
public class RegisterFormControllerTest {
	@InjectMocks
	private RegisterFormController controller;
	
	@Mock
	private RegisterFormService service;
	
	
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
	
}
