package com.example.fundraiser_new.controller;

import com.example.fundraiser_new.dto.CreateAccountCommand;
import com.example.fundraiser_new.service.AccountService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Void> registerAccount(@RequestBody CreateAccountCommand command, HttpServletRequest request){
        String ipAddress = request.getRemoteAddr();
        accountService.registerAccount(command, ipAddress);
        log.info("account created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
