package com.sjprogramming.bankapp.BankManagementApp.controller;

import com.sjprogramming.bankapp.BankManagementApp.entity.Account;
import com.sjprogramming.bankapp.BankManagementApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    // Create a new account
    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    // Get account details by account number
    @GetMapping("/{accountNumber}")
    public Account getAccountById(@PathVariable Long accountNumber) {
        return accountService.getAccountDetailsByAccountNumber(accountNumber);
    }

    // Get all account details
    @GetMapping
    public List<Account> getAllAccounts() {
        return accountService.getAllAccountDetails();
    }

    // Deposit amount
    @PutMapping("/{accountNumber}/deposit")
    public Account depositAmount(@PathVariable Long accountNumber, @RequestParam Double amount) {
        return accountService.depositAmount(accountNumber, amount);
    }

    // Withdraw amount
    @PutMapping("/{accountNumber}/withdraw")
    public Account withdrawAmount(@PathVariable Long accountNumber, @RequestParam Double amount) {
        return accountService.withdrawAmount(accountNumber, amount);
    }

    // Close account
    @DeleteMapping("/{accountNumber}")
    public String closeAccount(@PathVariable Long accountNumber) {
        accountService.closeAccount(accountNumber);
        return "Account with account number " + accountNumber + " has been closed.";
    }
}
