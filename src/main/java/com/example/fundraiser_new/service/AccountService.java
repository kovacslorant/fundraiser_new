package com.example.fundraiser_new.service;

import com.example.fundraiser_new.domain.Account;
import com.example.fundraiser_new.dto.CreateAccountCommand;
import com.example.fundraiser_new.dto.TargetAccountOption;
import com.example.fundraiser_new.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void registerAccount(CreateAccountCommand command, String ipAddress) {
        List<Account> accounts = accountRepository.findAll();
        for(Account account : accounts){
            if(account.getIpAddress().equals(ipAddress)){
                throw new IllegalArgumentException("There is already a user with this p address");
            }
        }
        Account account =  mappCreateAccountCommandToAccount(command, ipAddress);
        accountRepository.save(account);
    }

    private Account mappCreateAccountCommandToAccount(CreateAccountCommand command, String ipAddress) {
        Account account = new Account();
        account.setUsername(command.getUsername());
        account.setIpAddress(ipAddress);
        account.setGoal(command.getGoal());
        account.setBalance(5000);
        account.setFund(0);
        return account;
    }

    public Account findAccountByIp(String remoteAddr){
        return accountRepository.findAccountByIpAddress(remoteAddr);
    }

    public List<TargetAccountOption> getAllAccountsException(String remoteAddr) {
        List<Account> accounts = accountRepository.findAll();
        Account ownAccount = findAccountByIp(remoteAddr);
        accounts.remove(remoteAddr);
        List<TargetAccountOption> accountOptions = new ArrayList<>();
        for (Account account : accounts){
            TargetAccountOption option = new TargetAccountOption();
            option.setId(account.getId());
            option.setGoal(account.getGoal());
            accountOptions.add(option);
        }
        return accountOptions;
    }

    public Account findById(Long id){
        Account account = accountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return account;
    }
}
