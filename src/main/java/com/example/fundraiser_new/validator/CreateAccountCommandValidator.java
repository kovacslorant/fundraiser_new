package com.example.fundraiser_new.validator;

import com.example.fundraiser_new.domain.Account;
import com.example.fundraiser_new.dto.CreateAccountCommand;
import com.example.fundraiser_new.repository.AccountRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component

public class CreateAccountCommandValidator implements Validator {

   private AccountRepository accountRepository;
   private HttpServletRequest request;

    public CreateAccountCommandValidator(AccountRepository accountRepository, HttpServletRequest request) {
        this.accountRepository = accountRepository;
        this.request = request;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return CreateAccountCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreateAccountCommand command = (CreateAccountCommand) target;
        String ipAddress = request.getRemoteAddr();

        Account account = accountRepository.findAccountByIpAddress(ipAddress);

        if(account != null) {
            errors.rejectValue("username", "ipAddress.already.used");
        }

        String[] goalWords = command.getGoal().split(" ");
        if (goalWords.length < 2){
            errors.rejectValue("goal", "goal.less.than.two.words");

        }
    }
}
