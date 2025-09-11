package com.tka.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.BankAccount;
import com.tka.service.BankAccountService;

@RestController
@RequestMapping("/account")
public class BankAccountController {

	@Autowired // Field Based Injection
	BankAccountService service;

//	//@Autowired   Setter Based Injection
//	public void setService(BankAccountService service) {
//		this.service = service;
//	}
//	
//	// Constructor Based Injection
//	public BankAccountController(BankAccountService service) {
//		super();
//		this.service = service;
//	}

	@PostMapping("/create-account")
	public BankAccount createAccount(@RequestBody @Valid BankAccount account) {

		System.out.println("account creation in process...");
		boolean isCreated = service.createAccount(account);
		if (isCreated) {
			return account;
		} else {
			return null;
		}

	}

	@GetMapping("/get-by-id/{id}")
	public BankAccount getAccountById(@PathVariable long id) {

		BankAccount account = service.getAccountById(id);

		return account;
	}

	@DeleteMapping("/delete-by-id")
	public String deleteAccount(@RequestParam long id) {

		String msg = service.deleteAccount(id);
		return msg;

	}

	@PutMapping("/update-account")
	public String updateAccount(@RequestBody BankAccount account) {
		String msg = service.updateAccount(account);
		return msg;
	}
	
	

	@PutMapping("/{id}/deposit")
	public BankAccount deposit(@PathVariable Long id, @RequestParam Double amount) {
		return service.depositAmount(id, amount);
	}

	@PutMapping("/{id}/withdraw")
	public BankAccount withdraw(@PathVariable Long id, @RequestParam Double amount) {
		return service.withdrawAmount(id, amount);
	}

	@PutMapping("/transfer")
	public String transfer(@RequestParam Long fromId, @RequestParam Long toId, @RequestParam Double amount) {
		return service.transferFunds(fromId, toId, amount);
	}

	@GetMapping("/{id}/balance")
	public Double getBalance(@PathVariable Long id) {
		return service.getBalance(id);
	}

	@GetMapping("/type/{type}")
	public List<BankAccount> getAccountsByType(@PathVariable String type) {
		return service.getAccountsByType(type);
	}

	@GetMapping("/balance-range")
	public List<BankAccount> getAccountsByBalanceRange(@RequestParam Double min, @RequestParam Double max) {
		return service.getAccountsByBalanceRange(min, max);
	}

	@PutMapping("/{id}/block")
	public BankAccount blockAccount(@PathVariable Long id) {
		return service.blockAccount(id);
	}

	@PutMapping("/{id}/unblock")
	public BankAccount unblockAccount(@PathVariable Long id) {
		return service.unblockAccount(id);
	}

	@PutMapping("/{id}/close")
	public BankAccount closeAccount(@PathVariable Long id) {
		return service.closeAccount(id);
	}

}
