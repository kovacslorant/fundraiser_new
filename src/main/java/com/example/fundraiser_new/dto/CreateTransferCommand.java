package com.example.fundraiser_new.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateTransferCommand {

    private Long id;
    private Long target;
    private Integer amount;
}
