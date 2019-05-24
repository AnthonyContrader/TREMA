package it.contrader.service;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.contrader.dao.*;
import it.contrader.main.TestUtils;
import it.contrader.model.User;
import it.contrader.service.UserService;

import org.junit.Assert;

public class UserServiceTest {

	private UserDAO userTest;
	private UserService userService;
	private int userIdTest;
	
	@Before
	public void setUp() throws Exception {
		userTest = new UserDAO();
		userService = new UserService();
		userService.insertUser(userTest);
		userIdTest = TestUtils.getLastInsertedID("user");
		userTest.setUserId(userIdTest);
	}

	@After
	public void tearDown() throws Exception {
		userService.deleteUser(userIdTest);
	}

	@Test
	public void testInsertUser() {
		UserDAO userInsertTest = new UserDAO();
		
		//userService.insertUser(userInsertTest);
		boolean userInsertedCheck = userService.insertUser(userInsertTest);
		
		int userInsertTestId = TestUtils.getLastInsertedID("user");
		userService.deleteUser(userInsertTestId);
		
		Assert.assertTrue(userInsertedCheck);
	}

	@Test
	public void testReadtUser() {
		UserDAO DBuser=userService.readUser(userIdTest);
		Assert.assertTrue(DBuser.equals(userTest));
	}

	@Test
	public void testUpdateUser() {
		userTest.setUsername("Usernamemodificata");
		userService.updateUser(userTest);
		UserDTO DBUser = userService.readUser(userIdTest);
		Assert.assertTrue(DBUser.getUsername().equals("Usernamemodificata"));
	}

	@Test
	public void testDeleteUser() {
		userService.deleteUser(userIdTest);
	}

}
