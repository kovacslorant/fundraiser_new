package com.example.fundraiser_new.controller;

import com.example.fundraiser_new.dto.CreateAccountCommand;
import com.example.fundraiser_new.service.AccountService;
import com.example.fundraiser_new.validator.CreateAccountCommandValidator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
@Slf4j
public class AccountController {

    private final AccountService accountService;
    private final CreateAccountCommandValidator createAccountCommandValidator;

    public AccountController(AccountService accountService, CreateAccountCommandValidator createAccountCommandValidator) {
        this.accountService = accountService;
        this.createAccountCommandValidator = createAccountCommandValidator;
    }

    @InitBinder("createAccountCommand")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(createAccountCommandValidator);
    }

    @PostMapping
    public ResponseEntity<Void> registerAccount(@Valid @RequestBody  CreateAccountCommand command, HttpServletRequest request){
        String ipAddress = request.getRemoteAddr();
        accountService.registerAccount(command, ipAddress);
        log.info("account created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
