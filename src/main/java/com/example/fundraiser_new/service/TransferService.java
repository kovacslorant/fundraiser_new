package com.example.fundraiser_new.service;

import com.example.fundraiser_new.domain.Account;
import com.example.fundraiser_new.domain.Transfer;
import com.example.fundraiser_new.dto.CreateTransferCommand;
import com.example.fundraiser_new.dto.TargetAccountOption;
import com.example.fundraiser_new.dto.TransferInitData;
import com.example.fundraiser_new.repository.TransferRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final TransferRepository transferRepository;
    private final AccountService accountService;

    public TransferService(TransferRepository transferRepository, AccountService service) {
        this.transferRepository = transferRepository;
        this.accountService = service;
    }

    public TransferInitData getNewTransferData(String remoteAddr){

        Account accountLoggedIn = accountService.findAccountByIp(remoteAddr);
        List<TargetAccountOption> targetAccountOptions = accountService.getAllAccountsException(remoteAddr);
        return new TransferInitData(accountLoggedIn.getUsername(),targetAccountOptions,accountLoggedIn.getBalance());
    }

    public Transfer saveTransfer(CreateTransferCommand command, String ipAddress) {
        Account source = accountService.findAccountByIp(ipAddress);
        Account target = accountService.findById(command.getTarget());
        Transfer newTransfer = null;

        if(source != null && target != null
        && command.getAmount() <= source.getBalance()
        && command.getAmount() >= 50  && command.getAmount() <= 1000){
            newTransfer = new Transfer();
            newTransfer.setSource(source);
            newTransfer.setTarget(target);
            newTransfer.setAmount(command.getAmount());
            newTransfer.setTimeStamp(LocalDateTime.now());

            source.setBalance(source.getBalance() - command.getAmount());
            target.setFund(target.getFund() + command.getAmount());
            newTransfer = transferRepository.save(newTransfer);
        }
        return newTransfer;



    }
}
