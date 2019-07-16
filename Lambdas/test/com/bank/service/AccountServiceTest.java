package com.bank.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class AccountServiceTest {

	@Test
	public void createAccount_returns_valid_id_balance_gt_minbal() {
		//arrange
		AccountService service = new AccountService();
		//act
		int id = service.createNewAccount("SA",10001);
		//Asserts
		assertTrue(id>0);
		
	}

}
