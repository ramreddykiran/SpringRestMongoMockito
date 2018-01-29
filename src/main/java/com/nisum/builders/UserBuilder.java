package com.nisum.builders;

import org.apache.commons.lang3.builder.Builder;

import com.nisum.domain.User;

public class UserBuilder implements Builder<User>{
	
	private String userId = "defaultEmspId";;
	private String firstName = "defaultFirstEmpName";
	private String lastName = "defaultLastName";
	
	@Override
	public User build() {
		User user = new User();
		user.setUserId(userId);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return user;
	}
	
	public UserBuilder withUserId(String userId){
		this.userId = userId;
		return this;
	}
	 public UserBuilder withFirstName(String firstName){
			this.firstName = firstName;
			return this;
		}
	 
	 public UserBuilder withLastName(String lastName){
			this.lastName = lastName;
			return this;
		}


}
