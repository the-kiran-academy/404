package com.tka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tka.dao.BankAccountDaoImpl;
import com.tka.entity.BankAccount;
import com.tka.exceptions.ResourceNotFoundEception;

//@Service
@Component
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountDaoImpl dao;

	@Override
	public boolean createAccount(BankAccount account) {
		boolean isCreated = dao.createAccount(account);
		return isCreated;
	}

	@Override
	public BankAccount getAccountById(long id) {

		BankAccount account = dao.getAccountById(id);
		if(account==null) {
			throw new ResourceNotFoundEception("Account Not Found for this Id "+id );
		}
		return account;

	}

	@Override
	public String deleteAccount(long id) {
		String msg = dao.deleteAccount(id);
		return msg;
	}

	@Override
	public String updateAccount(BankAccount account) {
		String msg = dao.updateAccount(account);
		return msg;
	}
	
	@Override
    public BankAccount depositAmount(Long accountId, Double amount) {
        BankAccount account = dao.getAccountById(accountId);
        account.setBalance(account.getBalance() + amount);
        dao.updateAccount(account);
        return account;
    }

    @Override
    public BankAccount withdrawAmount(Long accountId, Double amount) {
        BankAccount account = dao.getAccountById(accountId);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        dao.updateAccount(account);
        return account;
    }

    @Override
    public String transferFunds(Long fromId, Long toId, Double amount) {
        withdrawAmount(fromId, amount);
        depositAmount(toId, amount);
        return "Transfer successful from Account " + fromId + " to Account " + toId;
    }

    @Override
    public Double getBalance(Long accountId) {
        return dao.getAccountById(accountId).getBalance();
    }

    @Override
    public List<BankAccount> getAccountsByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public List<BankAccount> getAccountsByBalanceRange(Double min, Double max) {
        return dao.findByBalanceRange(min, max);
    }

    @Override
    public BankAccount blockAccount(Long accountId) {
        BankAccount account = dao.getAccountById(accountId);
        account.setStatus("BLOCKED");
        dao.updateAccount(account);
        return account;
    }

    @Override
    public BankAccount unblockAccount(Long accountId) {
        BankAccount account = dao.getAccountById(accountId);
        account.setStatus("ACTIVE");
        dao.updateAccount(account);
        return account;
    }

    @Override
    public BankAccount closeAccount(Long accountId) {
        BankAccount account = dao.getAccountById(accountId);
        account.setStatus("CLOSED");
        dao.updateAccount(account);
        return account;
    }

}
