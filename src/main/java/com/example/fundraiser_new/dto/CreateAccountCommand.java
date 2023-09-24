package com.example.fundraiser_new.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateAccountCommand {


    private String username;
    private String goal;
}
