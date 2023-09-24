package com.example.fundraiser_new.controller;

import com.example.fundraiser_new.domain.Transfer;
import com.example.fundraiser_new.dto.CreateTransferCommand;
import com.example.fundraiser_new.dto.TransferInitData;
import com.example.fundraiser_new.service.TransferService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @GetMapping("/newTransfer")
    public ResponseEntity<TransferInitData> newTransferData(HttpServletRequest request){
        TransferInitData response = transferService.getNewTransferData(request.getRemoteAddr());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> saveTransfer(@RequestBody CreateTransferCommand command, HttpServletRequest request){
        ResponseEntity response = new ResponseEntity(HttpStatus.CREATED);
        String ipAddress = request.getRemoteAddr();
        Transfer newTransfer = transferService.saveTransfer(command, ipAddress);
        if(newTransfer == null){
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return response;
    }

}
