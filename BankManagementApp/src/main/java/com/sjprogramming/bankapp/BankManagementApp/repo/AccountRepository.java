package com.sjprogramming.bankapp.BankManagementApp.repository;

import com.sjprogramming.bankapp.BankManagementApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
