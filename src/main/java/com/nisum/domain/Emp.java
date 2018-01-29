package com.nisum.domain;

/*import lombok.Getter;
import lombok.Setter;
@Getter
@Setter*/
public class Emp {
	private String empId;
	private Department dept;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}

}
