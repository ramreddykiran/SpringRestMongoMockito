package com.pkrm.repository.stub;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.testng.collections.Lists;

import com.pkrm.builders.UserBuilder;
import com.pkrm.domain.Emp;
import com.pkrm.domain.Example;
import com.pkrm.domain.User;
import com.pkrm.repository.IRegisterFormRepository;

@Repository
public class RegisterFormRepositoryStub implements IRegisterFormRepository {
	

	@Override
	public void saveUser(User user) {
		user = new User();
		user.setFirstName("fn");

	}

	@Override
	public User getUserDetails(String userId) {
		User user = new User();
		user.setFirstName("fn");
		return user;
	}

	@Override
	public void saveEx(Example ex) {
		/*try {
		mongoTemplate.insert(ex);
	} catch (Exception e) {
		throw new DataAccessException("some db issue", e);
	}*/
	}

	@Override
	public Example get(String deptId) {
		Example example = new Example();
		example.setEmp(new Emp());
		return example;
	}

	@Override
	public List<User> retrieveUsers() {
		List<User> users = Lists.newArrayList();
		users.add(new UserBuilder().build());
		return users;
		}

}
