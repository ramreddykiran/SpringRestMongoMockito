package com.nisum.domain;

/*import lombok.Getter;
import lombok.Setter;*/

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ex")
/*@Setter
@Getter*/
public class Example {
	
	@Id
	private Emp emp;
	
	private Double dbl;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Double getDbl() {
		return dbl;
	}

	public void setDbl(Double dbl) {
		this.dbl = dbl;
	}
	
}
