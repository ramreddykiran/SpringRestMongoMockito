package com.nisum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.testng.collections.Lists;

import com.nisum.builders.UserBuilder;
import com.nisum.domain.Example;
import com.nisum.domain.User;

@Repository
public class RegisterFormRepository implements IRegisterFormRepository{

	/*@Autowired
	private MongoTemplate mongoTemplate;
*/
	/*public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}*/

	@Override
	public void saveUser(User user) {
		/*try {
			mongoTemplate.insert(user); //only insert 
			//mongoTemplate.save(user); //insert or update
		} catch (Exception e) {
			throw new DataAccessException("some db issue", e);
		}*/

	}

	@Override
	public User getUserDetails(String userId) {
		User user = new UserBuilder().build();
		/*try {
			Query query = new Query();
			query.addCriteria(new Criteria().and("_id").is(userId));
			user = mongoTemplate.findOne(query, User.class);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage(), e);
		}*/
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
		Example user = new Example();
		/*try {
			Query query = new Query();
			query.addCriteria(new Criteria().and("_id.dept.deptId").is(deptId));
			user = mongoTemplate.findOne(query, Example.class);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage(), e);
		}*/
		return user;
	}

	@Override
	public List<User> retrieveUsers() {
		List<User> users = Lists.newArrayList();
		/*
		try {
			//Query query = new Query();
			//query.addCriteria(new Criteria().and("_id.dept.deptId").is(deptId));
		   users = mongoTemplate.findAll(User.class);
		} catch (Exception e) {
			throw new DataAccessException(e.getMessage(), e);
		}
		 */
		return users;
		}

}
