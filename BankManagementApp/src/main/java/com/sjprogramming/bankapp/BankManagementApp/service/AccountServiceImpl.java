package com.sjprogramming.bankapp.BankManagementApp.service;

import com.sjprogramming.bankapp.BankManagementApp.entity.Account;
import com.sjprogramming.bankapp.BankManagementApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repo;

    @Override
    public Account createAccount(Account account) {
        return repo.save(account);
    }

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber) {
        return repo.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with account number: " + accountNumber));
    }

    @Override
    public List<Account> getAllAccountDetails() {
        return repo.findAll();
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        Account account = getAccountDetailsByAccountNumber(accountNumber);
        account.setBalance(account.getBalance() + amount);
        return repo.save(account);
    }

    @Override
    public Account withdrawAmount(Long accountNumber, Double amount) {
        Account account = getAccountDetailsByAccountNumber(accountNumber);
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance in account number: " + accountNumber);
        }
        account.setBalance(account.getBalance() - amount);
        return repo.save(account);
    }

    @Override
    public void closeAccount(Long accountNumber) {
        Account account = getAccountDetailsByAccountNumber(accountNumber);
        repo.delete(account);
    }
}
