package com.tka.dao;

import java.util.List;

import com.tka.entity.BankAccount;

public interface BankAccountDao {

	boolean createAccount(BankAccount account);

	BankAccount getAccountById(long id);
	
	String updateAccount(BankAccount account);
	
	String deleteAccount(long id);

	
	List<BankAccount> findAll();

	List<BankAccount> findByType(String type);

	List<BankAccount> findByBalanceRange(Double min, Double max);
}
