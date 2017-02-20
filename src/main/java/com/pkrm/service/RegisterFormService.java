package com.pkrm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import com.pkrm.domain.Example;
import com.pkrm.domain.User;
import com.pkrm.exception.ValidationFailedException;
import com.pkrm.repository.RegisterFormRepository;

@Service
public class RegisterFormService {

	@Autowired
	private RegisterFormRepository registerFormRepository;

	public void saveUser(User user) {
		validateUserDetails(user);
		registerFormRepository.saveUser(user);
	}

	private void validateUserDetails(User user) {
		if(StringUtils.isBlank(user.getUserId()) || StringUtils.isBlank(user.getFirstName())){
			throw new ValidationFailedException("employee details validation failed");
		}
	}

	public User retrieveUserDetails(String userId) {
		User user = registerFormRepository.getUserDetails(userId);
		return user;
	}

	/*if(user == null){
			return null;
		}*/
	public void saveEx(Example ex) {
		registerFormRepository.saveEx(ex);
		
	}

	public Example getEmp(String deptId) {
		Example ex = registerFormRepository.get(deptId);
		return ex;
		
	}

	public List<User> retrieveUsers() {
		List<User> users = registerFormRepository.retrieveUsers();
		return users;
	}
	
}
