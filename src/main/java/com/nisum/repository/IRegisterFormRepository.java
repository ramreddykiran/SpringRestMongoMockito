package com.nisum.repository;

import java.util.List;

import com.nisum.domain.Example;
import com.nisum.domain.User;

public interface IRegisterFormRepository {

	List<User> retrieveUsers();

	void saveUser(User user);

	User getUserDetails(String userId);

	void saveEx(Example ex);

	Example get(String deptId);

}
