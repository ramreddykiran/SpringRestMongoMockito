package com.pkrm.repository;

import java.util.List;

import com.pkrm.domain.Example;
import com.pkrm.domain.User;

public interface IRegisterFormRepository {

	List<User> retrieveUsers();

	void saveUser(User user);

	User getUserDetails(String userId);

	void saveEx(Example ex);

	Example get(String deptId);

}
