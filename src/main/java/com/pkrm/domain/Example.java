package com.pkrm.domain;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ex")
@Setter
@Getter
public class Example {
	
	@Id
	private Emp emp;
	
	private Double dbl;
	
}
