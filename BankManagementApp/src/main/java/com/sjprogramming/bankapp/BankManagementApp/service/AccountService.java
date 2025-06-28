package com.sjprogramming.bankapp.BankManagementApp.service;

import java.util.List;
import com.sjprogramming.bankapp.BankManagementApp.entity.Account;

public interface AccountService {

    Account createAccount(Account account);

    Account getAccountDetailsByAccountNumber(Long accountNumber);

    List<Account> getAllAccountDetails();

    Account depositAmount(Long accountNumber, Double amount);

    Account withdrawAmount(Long accountNumber, Double amount);

    void closeAccount(Long accountNumber);
}
