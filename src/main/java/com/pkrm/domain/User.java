package com.pkrm.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Setter
@Getter
public class User {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
}
