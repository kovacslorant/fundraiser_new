package com.example.fundraiser_new.repository;

import com.example.fundraiser_new.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByIpAddress(String ipAddress);
}
