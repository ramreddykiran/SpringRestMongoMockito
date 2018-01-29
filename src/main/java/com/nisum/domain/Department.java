package com.nisum.domain;

/*import lombok.Getter;
import lombok.Setter;

@Getter
@Setter*/
public class Department {
	private String deptId;
	private String deptName;
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
