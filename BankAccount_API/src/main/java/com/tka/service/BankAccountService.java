package com.tka.service;

import java.util.List;

import com.tka.entity.BankAccount;

public interface BankAccountService {

	BankAccount getAccountById(long id);

	boolean createAccount(BankAccount account);

	String deleteAccount(long id);

	String updateAccount(BankAccount account);
	
	

	BankAccount depositAmount(Long accountId, Double amount);

	BankAccount withdrawAmount(Long accountId, Double amount);

	String transferFunds(Long fromId, Long toId, Double amount);

	Double getBalance(Long accountId);

	List<BankAccount> getAccountsByType(String type);

	List<BankAccount> getAccountsByBalanceRange(Double min, Double max);

	BankAccount blockAccount(Long accountId);

	BankAccount unblockAccount(Long accountId);

	BankAccount closeAccount(Long accountId);
}
