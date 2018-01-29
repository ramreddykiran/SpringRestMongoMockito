package com.nisum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nisum.domain.Example;
import com.nisum.domain.User;
import com.nisum.service.RegisterFormService;

@Controller
public class RegisterFormController {

	@Autowired
	//@Setter
	private RegisterFormService registerFormservice;
	
	 @RequestMapping(value="/save-employee", method = RequestMethod.POST)
	 @ResponseBody
	    public ResponseEntity<?> saveEmployee(@RequestBody User emp) throws Exception { try{
			 registerFormservice.saveUser(emp);
			 return new ResponseEntity<String>("success",HttpStatus.OK);
		 } catch(Exception e) {
			 return new ResponseEntity<String>("falure",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	    }
	 
	 @RequestMapping(value="/user-details", method = RequestMethod.GET)
	    public ResponseEntity<?> getUserDetails(@RequestParam(value = "user-id", required = true) String userId) {
		 try{
			 User response = registerFormservice.retrieveUserDetails(userId);
			 if(response == null) {
				 return new ResponseEntity<String>("No records found for userId "+userId, HttpStatus.NOT_FOUND);
			 }
			 return new ResponseEntity<User>(response, HttpStatus.OK);
		 } catch(Exception e) {
			 return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	 }
	 
	 @RequestMapping(value="/save", method = RequestMethod.POST)
	 @ResponseBody
	    public ResponseEntity<?> save(@RequestBody Example ex) throws Exception {
		 try{
			 registerFormservice.saveEx(ex);
			 return new ResponseEntity<String>("success",HttpStatus.OK);
		 } catch(Exception e) {
			 return new ResponseEntity<String>("falure",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	    }
	 
	/* @RequestMapping(value="/retrieve", method = RequestMethod.GET)
	   public ResponseEntity<?> get(@RequestParam(value = "dept-id", required = true) String deptId) throws Exception { try{*/
	 @RequestMapping(value="/retrieve/{dept-id}", method = RequestMethod.GET)
	 public ResponseEntity<?> get(@PathVariable(value="dept-id") String deptId) throws Exception { try{
	    	Example ex = registerFormservice.getEmp(deptId);
	    	if(null == ex) {
	    		return new ResponseEntity<String>("Employee not found ",HttpStatus.NOT_FOUND);
	    	} else {
	    		return new ResponseEntity<Example>(ex, HttpStatus.OK);
	    	}
		 } catch(Exception e) {
			 return new ResponseEntity<String>("falure",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	    }
	 
	 @RequestMapping(value="/users", method =  RequestMethod.GET)
		public ResponseEntity<?> getAllUsers() {
			List<User> employee = registerFormservice.retrieveUsers();
			return new ResponseEntity<List<User>>(employee, HttpStatus.OK);
		}

}
